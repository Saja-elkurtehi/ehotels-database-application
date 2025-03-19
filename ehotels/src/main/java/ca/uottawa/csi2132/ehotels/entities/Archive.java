package ca.uottawa.csi2132.ehotels.entities;

import java.time.LocalDate;

public class Archive {
    private Long archiveId;
    private LocalDate date;
    private String type;
    
    public Archive() {
    }

    public Archive(Long archiveId, LocalDate date, String type) {
        this.archiveId = archiveId;
        this.date = date;
        this.type = type;
    }

    public Long getArchiveId() {
        return archiveId;
    }
    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
