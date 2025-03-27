-- trigger to update num_of_rooms in hotel when a room is added or removed
CREATE OR REPLACE FUNCTION update_num_of_rooms() RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        UPDATE hotel 
        SET num_of_rooms = num_of_rooms + 1 
        WHERE hotel_ID = NEW.hotel_ID;
    ELSIF TG_OP = 'DELETE' THEN
        UPDATE hotel 
        SET num_of_rooms = num_of_rooms - 1 
        WHERE hotel_ID = OLD.hotel_ID;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER room_count_trigger
AFTER INSERT OR DELETE ON room
FOR EACH ROW EXECUTE FUNCTION update_num_of_rooms();


-- trigger to not allow double booking of a room
CREATE OR REPLACE FUNCTION prevent_double_booking() RETURNS TRIGGER AS $$
DECLARE
    new_check_in DATE;
    new_check_out DATE;
BEGIN
    -- getting date range for new booking
    SELECT check_in_date, check_out_date INTO new_check_in, new_check_out
    FROM booking
    WHERE booking_ID = NEW.booking_ID;
    
    -- chck if there's overlap with existing bookings
    IF EXISTS (
        SELECT 1 
        FROM books b
        JOIN booking bk ON b.booking_ID = bk.booking_ID
        WHERE b.room_ID = NEW.room_ID
        AND bk.booking_ID != NEW.booking_ID
        AND bk.status != 'cancelled'
        AND (
            (new_check_in <= bk.check_out_date) AND (new_check_out >= bk.check_in_date)
        )
    ) THEN
        RAISE EXCEPTION 'room is already booked for this period';
    END IF;
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- drop trigger first if it exists alr
DROP TRIGGER IF EXISTS check_double_booking ON books;

-- recreate trigger
CREATE TRIGGER check_double_booking
BEFORE INSERT ON books
FOR EACH ROW EXECUTE FUNCTION prevent_double_booking();