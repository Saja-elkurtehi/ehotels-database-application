--------------- QUERIES ------------------
-- Query 1: find all hotels in New York
SELECT * FROM hotel WHERE address LIKE '%New York, NY%';

-- Query 2: average room price
SELECT AVG(price) AS average_room_price FROM room;

-- Query 3: nested query. find hotels w/ rooms that have a sea view and no problems
SELECT h.hotel_ID, h.address
FROM hotel h
WHERE h.hotel_ID IN (
    SELECT r.hotel_ID
    FROM room r
    WHERE r.view_type = 'sea view' AND r.any_problems IS NULL
);

-- Query 4: find customers who booked rooms w/ city view
SELECT DISTINCT c.full_name AS customer_name, c.address, r.room_ID, r.view_type
FROM customer c
JOIN books bk ON c.customer_ID = bk.customer_ID
JOIN room r ON bk.room_ID = r.room_ID
JOIN booking b ON bk.booking_ID = b.booking_ID
WHERE r.view_type = 'city view';
