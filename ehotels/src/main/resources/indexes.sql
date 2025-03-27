-------------- INDEXES ----------------
-- for room searches by hotel and price
CREATE INDEX IF NOT EXISTS idx_room_hotel_price ON room(hotel_ID, price);

-- can be useful in customer booking history lookups
CREATE INDEX idx_room_hotel_id ON room(hotel_ID);

-- access to sea view rooms w/ probelms fast
CREATE INDEX IF NOT EXISTS idx_problem_sea_rooms ON room(view_type, any_problems)
WHERE any_problems IS NOT NULL;
