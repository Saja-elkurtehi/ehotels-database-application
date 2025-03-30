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

-- Query 5: rooms not booked or rented in the given date range and with capacity (i.e. number of guests) >= guests.
SELECT r.* FROM room r
            WHERE r.capacity >= ?
              AND r.room_ID NOT IN (
                  SELECT b.room_ID
                  FROM booking b
                  WHERE b.check_in_date < CAST(? AS DATE)
                    AND b.check_out_date > CAST(? AS DATE)
                    AND b.status = 'Reserved'
              )
              AND r.room_ID NOT IN (
                  SELECT rt.room_ID
                  FROM renting rt
                  WHERE rt.check_in_date < CAST(? AS DATE)
                    AND rt.check_out_date > CAST(? AS DATE)
              )
-- filter by hotel chain
SELECT r.* FROM room r
            JOIN hotel h ON r.hotel_ID = h.hotel_ID
            WHERE r.capacity >= ?
              AND h.hotel_chain_ID = ?
              AND r.room_ID NOT IN (
                  SELECT b.room_ID
                  FROM booking b
                  WHERE b.check_in_date < CAST(? AS DATE)
                    AND b.check_out_date > CAST(? AS DATE)
                    AND b.status = 'Reserved'
              )
              AND r.room_ID NOT IN (
                  SELECT rt.room_ID
                  FROM renting rt
                  WHERE rt.check_in_date < CAST(? AS DATE)
                    AND rt.check_out_date > CAST(? AS DATE)
              )