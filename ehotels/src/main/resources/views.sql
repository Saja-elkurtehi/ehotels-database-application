-- view 1 num of available rooms per area 
CREATE OR REPLACE VIEW available_rooms_per_area AS
SELECT
    h.address,
    COUNT(DISTINCT r.room_id) AS available_rooms
FROM
    room r
JOIN
    hotel h ON r.hotel_id = h.hotel_id
WHERE
    r.room_id NOT IN (
        -- Rooms with active bookings (CheckedIn status)
        SELECT DISTINCT b.room_id
        FROM booking b
        WHERE b.status = 'CheckedIn'
        AND CURRENT_DATE BETWEEN b.check_in_date AND b.check_out_date
        
        UNION
        
        -- Rooms with active rentings
        SELECT DISTINCT rnt.room_id
        FROM renting rnt
        WHERE rnt.status IN ('Active', 'Ongoing')
        AND CURRENT_DATE BETWEEN rnt.check_in_date AND rnt.check_out_date
    )
GROUP BY
    h.address;

-- view 2 aggregated capac of all rooms per hotel
CREATE OR REPLACE VIEW aggregated_room_capacity AS
SELECT 
    r.hotel_id, 
    SUM(r.capacity) AS total_capacity
FROM 
    room r
GROUP BY 
    r.hotel_id;
