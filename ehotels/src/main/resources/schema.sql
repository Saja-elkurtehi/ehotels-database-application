-- ==============================================
-- Hotel Chain Table
-- ==============================================
CREATE TABLE IF NOT EXISTS hotel_chain (
    hotel_chain_ID SERIAL PRIMARY KEY, 
    num_of_hotels INTEGER,
    address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS hotel_chain_phone (
    hotel_chain_ID INTEGER NOT NULL,
    phone VARCHAR(20) NOT NULL,
    CONSTRAINT fk_hotel_chain_phone FOREIGN KEY (hotel_chain_ID)
        REFERENCES hotel_chain (hotel_chain_ID)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS hotel_chain_email (
    hotel_chain_ID INTEGER NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT fk_hotel_chain_email FOREIGN KEY (hotel_chain_ID)
        REFERENCES hotel_chain (hotel_chain_ID)
        ON DELETE CASCADE
);
-- ==============================================
-- Hotel Table
-- ==============================================

CREATE TABLE IF NOT EXISTS hotel (
    hotel_ID SERIAL PRIMARY KEY, 
    hotel_chain_ID INTEGER NOT NULL,
    rating SMALLINT,
    num_of_rooms INTEGER,
    address VARCHAR(255),
    CONSTRAINT fk_chain FOREIGN KEY (hotel_chain_ID)
        REFERENCES hotel_chain (hotel_chain_ID)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS hotel_phone (
    hotel_ID INTEGER NOT NULL,
    phone VARCHAR(20) NOT NULL,
    CONSTRAINT fk_hotel_phone FOREIGN KEY (hotel_ID)
        REFERENCES hotel (hotel_ID)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS hotel_email (
    hotel_ID INTEGER NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT fk_hotel_email FOREIGN KEY (hotel_ID)
        REFERENCES hotel (hotel_ID)
        ON DELETE CASCADE
);
-- ==============================================
-- Room Table
-- ==============================================

CREATE TABLE IF NOT EXISTS room (
    room_ID SERIAL PRIMARY KEY,
    hotel_ID INTEGER NOT NULL,
    price BIGINT,
    extension BOOLEAN,
    capacity SMALLINT,
    view_type VARCHAR(255),
    any_problems TEXT,
    CONSTRAINT fk_hotel_room FOREIGN KEY (hotel_ID)
        REFERENCES hotel (hotel_ID)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS room_amenity (
    room_ID INTEGER NOT NULL,
    amenity VARCHAR(255) NOT NULL,
    CONSTRAINT fk_room_amenity FOREIGN KEY (room_ID)
        REFERENCES room (room_ID)
        ON DELETE CASCADE
);
-- ==============================================
-- Employee Table
-- ==============================================

CREATE TABLE IF NOT EXISTS employee (
    employee_ID SERIAL PRIMARY KEY,
    SSN INTEGER NOT NULL, 
    full_name VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS employee_role (
    employee_ID INTEGER NOT NULL,
    role VARCHAR(255) NOT NULL,
    CONSTRAINT fk_employee_role FOREIGN KEY (employee_ID)
        REFERENCES employee (employee_ID)
        ON DELETE CASCADE
);
-- ==============================================
-- Manager Table
-- ==============================================

CREATE TABLE IF NOT EXISTS manager (
    employee_ID INTEGER NOT NULL,
    hotel_ID INTEGER NOT NULL,
    CONSTRAINT fk_manager_id FOREIGN KEY (employee_ID)
        REFERENCES employee (employee_ID)
        ON DELETE CASCADE,
    CONSTRAINT fk_hotel FOREIGN KEY (hotel_ID)
        REFERENCES hotel (hotel_ID)
        ON DELETE CASCADE
);
-- ==============================================
-- Customer Table
-- ==============================================
CREATE TABLE IF NOT EXISTS customer (
    customer_ID SERIAL PRIMARY KEY,
    SSN VARCHAR(50) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    registration_date DATE NOT NULL
);

-- ==============================================
-- Booking Table
-- ==============================================
CREATE TABLE IF NOT EXISTS booking (
    booking_ID SERIAL PRIMARY KEY,
    status VARCHAR(50),
    booking_date DATE NOT NULL,
    check_in_date DATE,
    check_out_date DATE
);

-- ==============================================
-- Books Table (booking ↔ customer ↔ room)
-- ==============================================
CREATE TABLE IF NOT EXISTS books (
    booking_ID INTEGER NOT NULL,
    customer_ID INTEGER NOT NULL,
    room_ID INTEGER NOT NULL,
    CONSTRAINT fk_books_booking FOREIGN KEY (booking_ID)
        REFERENCES booking (booking_ID)
        ON DELETE CASCADE,
    CONSTRAINT fk_books_customer FOREIGN KEY (customer_ID)
        REFERENCES customer (customer_ID)
        ON DELETE CASCADE,
    CONSTRAINT fk_books_room FOREIGN KEY (room_ID)
        REFERENCES room (room_ID)
        ON DELETE CASCADE
);

-- ==============================================
-- Renting Table
-- ==============================================
CREATE TABLE IF NOT EXISTS renting (
    renting_ID SERIAL PRIMARY KEY,
    customer_ID INTEGER NOT NULL,
    room_ID INTEGER NOT NULL,
    employee_ID INTEGER NOT NULL,
    check_in_date DATE NOT NULL,
    check_out_date DATE,
    status VARCHAR(50)
);

-- ==============================================
-- Archive Table
-- ==============================================
CREATE TABLE IF NOT EXISTS archive (
    archive_ID SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    type VARCHAR(50) NOT NULL
);

-- ==============================================
-- Archives Table
-- ==============================================
CREATE TABLE IF NOT EXISTS archives (
    archive_ID INTEGER NOT NULL,
    renting_ID INTEGER NOT NULL,
    booking_ID INTEGER NOT NULL,
    CONSTRAINT fk_archives_archive FOREIGN KEY (archive_ID)
        REFERENCES archive (archive_ID)
        ON DELETE CASCADE,
    CONSTRAINT fk_archives_renting FOREIGN KEY (renting_ID)
        REFERENCES renting (renting_ID)
        ON DELETE CASCADE,
    CONSTRAINT fk_archives_booking FOREIGN KEY (booking_ID)
        REFERENCES booking (booking_ID)
        ON DELETE CASCADE
);

-- ==============================================
-- ChecksIn Table
-- ==============================================
CREATE TABLE IF NOT EXISTS checks_in (
    customer_ID INTEGER NOT NULL,
    room_ID INTEGER NOT NULL,
    employee_ID INTEGER NOT NULL,
    check_in_date DATE NOT NULL,
    booking_ID INTEGER,   -- optional if there's a prior booking
    CONSTRAINT fk_checks_in_customer FOREIGN KEY (customer_ID)
        REFERENCES customer (customer_ID)
        ON DELETE CASCADE,
    CONSTRAINT fk_checks_in_room FOREIGN KEY (room_ID)
        REFERENCES room (room_ID)
        ON DELETE CASCADE,
    CONSTRAINT fk_checks_in_employee FOREIGN KEY (employee_ID)
        REFERENCES employee (employee_ID)
        ON DELETE SET NULL,
    CONSTRAINT fk_checks_in_booking FOREIGN KEY (booking_ID)
        REFERENCES booking (booking_ID)
        ON DELETE SET NULL
);
