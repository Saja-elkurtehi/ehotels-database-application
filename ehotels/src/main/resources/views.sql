-- view 1 num of available rooms per area 
CREATE OR REPLACE VIEW available_rooms_per_area AS
SELECT 
    h.address, 
    COUNT(*) AS available_rooms
FROM 
    room r
JOIN 
    hotel h ON r.hotel_id = h.hotel_id
LEFT JOIN 
    books b ON r.room_id = b.room_id
LEFT JOIN 
    booking bk ON b.booking_id = bk.booking_id
WHERE 
    bk.status != 'confirmed' OR bk.status IS NULL
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