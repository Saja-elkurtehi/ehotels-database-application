package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class ArchiveRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert into archive table
    public Long insertArchive(Archive archive) {
        String sql = "INSERT INTO archive (date, type) VALUES (?, ?) RETURNING archive_ID";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{Date.valueOf(archive.getDate()), archive.getType()},
                Long.class);
    }

    // Link archive to a booking and renting
    public void linkToBookingAndRenting(Long archiveId, Long bookingId, Long rentingId) {
        String sql = "INSERT INTO archives (archive_ID, booking_ID, renting_ID) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, archiveId, bookingId, rentingId);
    }

    // Get all archives
    public List<Archive> getAllArchives() {
        String sql = "SELECT * FROM archive";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Archive(
                rs.getLong("archive_ID"),
                rs.getDate("date").toLocalDate(),
                rs.getString("type")
        ));
    }

    // Get archive by ID
    public Archive getArchiveById(Long archiveId) {
        String sql = "SELECT * FROM archive WHERE archive_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{archiveId}, (rs, rowNum) -> new Archive(
                rs.getLong("archive_ID"),
                rs.getDate("date").toLocalDate(),
                rs.getString("type")
        ));
    }

    // Delete an archive
    public void deleteArchive(Long archiveId) {
        String sql = "DELETE FROM archive WHERE archive_ID = ?";
        jdbcTemplate.update(sql, archiveId);
    }
}
