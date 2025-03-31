-- trigger to update num_of_rooms in hotel when a room is added or removed
CREATE OR REPLACE FUNCTION update_num_of_rooms()
RETURNS TRIGGER AS '
BEGIN
    IF TG_OP = ''INSERT'' THEN
        UPDATE hotel 
        SET num_of_rooms = num_of_rooms + 1 
        WHERE hotel_ID = NEW.hotel_ID;
    ELSIF TG_OP = ''DELETE'' THEN
        UPDATE hotel 
        SET num_of_rooms = num_of_rooms - 1 
        WHERE hotel_ID = OLD.hotel_ID;
    END IF;
    RETURN NULL;
END;
' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS room_count_trigger ON room;

CREATE TRIGGER room_count_trigger
AFTER INSERT OR DELETE ON room
FOR EACH ROW EXECUTE FUNCTION update_num_of_rooms();



-- trigger to not allow double booking of a room
CREATE OR REPLACE FUNCTION prevent_double_booking()
RETURNS TRIGGER AS '
BEGIN
    IF EXISTS (
        SELECT 1
        FROM books b
        JOIN booking bk ON b.booking_ID = bk.booking_ID
        WHERE b.room_ID = NEW.room_ID
        AND bk.booking_ID != NEW.booking_ID
        AND bk.status != ''cancelled''
        AND (
            (bk.check_in_date <= (SELECT check_out_date FROM booking WHERE booking_ID = NEW.booking_ID)) AND
            (bk.check_out_date >= (SELECT check_in_date FROM booking WHERE booking_ID = NEW.booking_ID))
        )
    ) THEN
        RAISE EXCEPTION ''Room % is already booked for the selected dates'', NEW.room_ID;
    END IF;
    RETURN NEW;
END;
' LANGUAGE plpgsql;