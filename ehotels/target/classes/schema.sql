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
