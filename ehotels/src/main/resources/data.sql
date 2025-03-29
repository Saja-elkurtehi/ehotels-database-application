-- ========================================================
-- 1. Hotel Chain Data
-- ========================================================

-- Insert Hotel Chains (each with 8 hotels)
INSERT INTO hotel_chain (num_of_hotels, address) VALUES
  (8, '100 Hilton Street, New York, NY'),
  (8, '200 Marriott Road, Chicago, IL'),
  (8, '300 Hyatt Crescent, Miami, FL'),
  (8, '400 InterContinental Drive, Los Angeles, CA'),
  (8, '500 Accor Avenue, San Francisco, CA');

-- Insert Hotel Chain Phones
INSERT INTO hotel_chain_phone (hotel_chain_ID, phone) VALUES
  (1, '212-000-1111'),
  (2, '312-000-2222'),
  (3, '305-000-3333'),
  (4, '213-000-4444'),
  (5, '415-000-5555');

-- Insert Hotel Chain Emails
INSERT INTO hotel_chain_email (hotel_chain_ID, email) VALUES
  (1, 'info@hilton.com'),
  (2, 'contact@marriott.com'),
  (3, 'support@hyatt.com'),
  (4, 'services@intercontinental.com'),
  (5, 'hello@accor.com');

-- ========================================================
-- 2. Hotel Data
-- ========================================================

-- ========================================================
-- 1. Hilton (hotel_chain_ID = 1) -- Two hotels in New York ensure the “same area” requirement.
INSERT INTO hotel (hotel_chain_ID, rating, num_of_rooms, address) VALUES
  (1, 5, 120, '1 Hilton Drive, New York, NY'),
  (1, 4, 100, '2 Hilton Street, New York, NY'),
  (1, 3, 80,  '3 Hilton Avenue, Boston, MA'),
  (1, 4, 90,  '4 Hilton Boulevard, Philadelphia, PA'),
  (1, 5, 110, '5 Hilton Road, Washington, DC'),
  (1, 4, 95,  '6 Hilton Court, Miami, FL'),
  (1, 3, 70,  '7 Hilton Terrace, Atlanta, GA'),
  (1, 4, 85,  '8 Hilton Place, Seattle, WA');

-- ========================================================
-- 2. Marriott (hotel_chain_ID = 2) -- Two hotels in Chicago.
INSERT INTO hotel (hotel_chain_ID, rating, num_of_rooms, address) VALUES
  (2, 5, 130, '1 Marriott Drive, Chicago, IL'),
  (2, 4, 110, '2 Marriott Street, Chicago, IL'),
  (2, 3, 90,  '3 Marriott Avenue, Detroit, MI'),
  (2, 4, 100, '4 Marriott Boulevard, Cleveland, OH'),
  (2, 5, 120, '5 Marriott Road, St. Louis, MO'),
  (2, 4, 105, '6 Marriott Court, Minneapolis, MN'),
  (2, 3, 85,  '7 Marriott Terrace, Indianapolis, IN'),
  (2, 4, 95,  '8 Marriott Place, Cincinnati, OH');

-- ========================================================
-- 3. Hyatt (hotel_chain_ID = 3) -- Two hotels in Miami.
INSERT INTO hotel (hotel_chain_ID, rating, num_of_rooms, address) VALUES
  (3, 5, 140, '1 Hyatt Drive, Miami, FL'),
  (3, 4, 115, '2 Hyatt Street, Miami, FL'),
  (3, 3, 95,  '3 Hyatt Avenue, Orlando, FL'),
  (3, 4, 105, '4 Hyatt Boulevard, Tampa, FL'),
  (3, 5, 125, '5 Hyatt Road, Atlanta, GA'),
  (3, 4, 110, '6 Hyatt Court, New Orleans, LA'),
  (3, 3, 90,  '7 Hyatt Terrace, Dallas, TX'),
  (3, 4, 100, '8 Hyatt Place, Houston, TX');

-- ========================================================
-- 4. InterContinental (hotel_chain_ID = 4) -- Two hotels in Los Angeles.
INSERT INTO hotel (hotel_chain_ID, rating, num_of_rooms, address) VALUES
  (4, 5, 150, '1 InterContinental Drive, Los Angeles, CA'),
  (4, 4, 120, '2 InterContinental Street, Los Angeles, CA'),
  (4, 3, 100, '3 InterContinental Avenue, San Diego, CA'),
  (4, 4, 110, '4 InterContinental Boulevard, San Francisco, CA'),
  (4, 5, 130, '5 InterContinental Road, Phoenix, AZ'),
  (4, 4, 115, '6 InterContinental Court, Las Vegas, NV'),
  (4, 3, 95,  '7 InterContinental Terrace, Portland, OR'),
  (4, 4, 105, '8 InterContinental Place, Seattle, WA');

-- ========================================================
-- 5. Accor (hotel_chain_ID = 5) -- Two hotels in San Francisco.
INSERT INTO hotel (hotel_chain_ID, rating, num_of_rooms, address) VALUES
  (5, 5, 160, '1 Accor Drive, San Francisco, CA'),
  (5, 4, 130, '2 Accor Street, San Francisco, CA'),
  (5, 3, 110, '3 Accor Avenue, Los Angeles, CA'),
  (5, 4, 120, '4 Accor Boulevard, San Diego, CA'),
  (5, 5, 140, '5 Accor Road, Las Vegas, NV'),
  (5, 4, 125, '6 Accor Court, Phoenix, AZ'),
  (5, 3, 105, '7 Accor Terrace, Portland, OR'),
  (5, 4, 115, '8 Accor Place, Seattle, WA');

-- ========================================================
-- 3. Hotel Contact Data
-- ========================================================

-- Insert Hotel Phones
INSERT INTO hotel_phone (hotel_ID, phone) VALUES
  -- Hilton hotels: hotel_IDs 1 to 8
  (1, '212-101-0001'),
  (2, '212-101-0002'),
  (3, '212-101-0003'),
  (4, '212-101-0004'),
  (5, '212-101-0005'),
  (6, '212-101-0006'),
  (7, '212-101-0007'),
  (8, '212-101-0008'),
  -- Marriott hotels: hotel_IDs 9 to 16
  (9, '312-202-0001'),
  (10, '312-202-0002'),
  (11, '312-202-0003'),
  (12, '312-202-0004'),
  (13, '312-202-0005'),
  (14, '312-202-0006'),
  (15, '312-202-0007'),
  (16, '312-202-0008'),
  -- Hyatt hotels: hotel_IDs 17 to 24
  (17, '305-303-0001'),
  (18, '305-303-0002'),
  (19, '305-303-0003'),
  (20, '305-303-0004'),
  (21, '305-303-0005'),
  (22, '305-303-0006'),
  (23, '305-303-0007'),
  (24, '305-303-0008'),
  -- InterContinental hotels: hotel_IDs 25 to 32
  (25, '213-404-0001'),
  (26, '213-404-0002'),
  (27, '213-404-0003'),
  (28, '213-404-0004'),
  (29, '213-404-0005'),
  (30, '213-404-0006'),
  (31, '213-404-0007'),
  (32, '213-404-0008'),
  -- Accor hotels: hotel_IDs 33 to 40
  (33, '415-505-0001'),
  (34, '415-505-0002'),
  (35, '415-505-0003'),
  (36, '415-505-0004'),
  (37, '415-505-0005'),
  (38, '415-505-0006'),
  (39, '415-505-0007'),
  (40, '415-505-0008');

-- Insert Hotel Emails
INSERT INTO hotel_email (hotel_ID, email) VALUES
  -- Hilton hotels
  (1, 'nydowntown@hilton.com'),
  (2, 'nymidtown@hilton.com'),
  (3, 'boston@hilton.com'),
  (4, 'philadelphia@hilton.com'),
  (5, 'washington@hilton.com'),
  (6, 'miami@hilton.com'),
  (7, 'atlanta@hilton.com'),
  (8, 'seattle@hilton.com'),
  -- Marriott hotels
  (9,  'chicagodowntown@marriott.com'),
  (10, 'chicagonorth@marriott.com'),
  (11, 'detroit@marriott.com'),
  (12, 'cleveland@marriott.com'),
  (13, 'stlouis@marriott.com'),
  (14, 'minneapolis@marriott.com'),
  (15, 'indianapolis@marriott.com'),
  (16, 'cincinnati@marriott.com'),
  -- Hyatt hotels
  (17, 'miamibeach@hyatt.com'),
  (18, 'miamidowntown@hyatt.com'),
  (19, 'orlando@hyatt.com'),
  (20, 'tampa@hyatt.com'),
  (21, 'atlanta@hyatt.com'),
  (22, 'neworleans@hyatt.com'),
  (23, 'dallas@hyatt.com'),
  (24, 'houston@hyatt.com'),
  -- InterContinental hotels
  (25, 'la-downtown@intercontinental.com'),
  (26, 'la-west@intercontinental.com'),
  (27, 'sandiego@intercontinental.com'),
  (28, 'sanfrancisco@intercontinental.com'),
  (29, 'phoenix@intercontinental.com'),
  (30, 'lasvegas@intercontinental.com'),
  (31, 'portland@intercontinental.com'),
  (32, 'seattle@intercontinental.com'),
  -- Accor hotels
  (33, 'sfdowntown@accor.com'),
  (34, 'sfbay@accor.com'),
  (35, 'la@accor.com'),
  (36, 'sandiego@accor.com'),
  (37, 'lasvegas@accor.com'),
  (38, 'phoenix@accor.com'),
  (39, 'portland@accor.com'),
  (40, 'seattle@accor.com');

-- ========================================================
-- 4. Room Data
-- ========================================================
--=========================================
-- Rooms for the Hilton Hotel 
--=========================================
-- Rooms for Hotel_ID = 1
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (1, 250, TRUE,  1, 'sea view', NULL),
  (1, 300, TRUE,  2, 'sea view', 'Minor scratch on window'),
  (1, 350, FALSE, 3, 'city view', NULL),
  (1, 275, TRUE,  4, 'mountain view', NULL),
  (1, 320, FALSE, 5, 'city view', 'AC issue');

-- Rooms for Hotel_ID = 2
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (2, 260, TRUE,  1, 'city view', NULL),
  (2, 310, TRUE,  2, 'sea view', NULL),
  (2, 360, FALSE, 3, 'mountain view', 'Window crack'),
  (2, 285, TRUE,  4, 'sea view', NULL),
  (2, 330, FALSE, 5, 'city view', NULL);

-- Rooms for Hotel_ID = 3
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (3, 240, TRUE,  1, 'city view', NULL),
  (3, 290, TRUE,  2, 'sea view', 'Minor leak in bathroom'),
  (3, 340, FALSE, 3, 'mountain view', NULL),
  (3, 260, TRUE,  4, 'garden view', NULL),
  (3, 310, FALSE, 5, 'city view', 'Broken lamp');

-- Rooms for Hotel_ID = 4
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (4, 255, TRUE,  1, 'city view', NULL),
  (4, 305, TRUE,  2, 'sea view', NULL),
  (4, 355, FALSE, 3, 'mountain view', 'Cracked window'),
  (4, 280, TRUE,  4, 'garden view', NULL),
  (4, 330, FALSE, 5, 'city view', 'Minor wall dent');

-- Rooms for Hotel_ID = 5
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (5, 265, TRUE,  1, 'city view', NULL),
  (5, 315, TRUE,  2, 'sea view', 'Stained carpet'),
  (5, 365, FALSE, 3, 'mountain view', NULL),
  (5, 290, TRUE,  4, 'garden view', NULL),
  (5, 340, FALSE, 5, 'city view', 'Faulty AC');

-- Rooms for Hotel_ID = 6
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (6, 270, TRUE,  1, 'sea view', NULL),
  (6, 320, TRUE,  2, 'city view', 'Minor crack in door'),
  (6, 370, FALSE, 3, 'ocean view', NULL),
  (6, 295, TRUE,  4, 'city view', NULL),
  (6, 345, FALSE, 5, 'ocean view', 'Noisy air conditioner');

-- Rooms for Hotel_ID = 7
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (7, 275, TRUE,  1, 'city view', NULL),
  (7, 325, TRUE,  2, 'garden view', NULL),
  (7, 375, FALSE, 3, 'mountain view', 'Minor leak'),
  (7, 300, TRUE,  4, 'city view', NULL),
  (7, 350, FALSE, 5, 'garden view', 'Window scratch');

-- Rooms for Hotel_ID = 8
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (8, 280, TRUE,  1, 'sea view', NULL),
  (8, 330, TRUE,  2, 'city view', NULL),
  (8, 380, FALSE, 3, 'mountain view', 'Cracked tile'),
  (8, 305, TRUE,  4, 'city view', NULL),
  (8, 355, FALSE, 5, 'sea view', 'Faulty heater');
--=========================================
-- Rooms for the Marriot Hotel 
--=========================================

-- Rooms for Hotel_ID = 9
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (9, 280, TRUE,  1, 'city view', NULL),
  (9, 330, TRUE,  2, 'sea view', 'Minor wall scuff'),
  (9, 380, FALSE, 3, 'mountain view', NULL),
  (9, 310, TRUE,  4, 'garden view', NULL),
  (9, 360, FALSE, 5, 'city view', 'AC issue');

-- Rooms for Hotel_ID = 10
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (10, 290, TRUE,  1, 'city view', NULL),
  (10, 340, TRUE,  2, 'sea view', 'Minor door scratch'),
  (10, 390, FALSE, 3, 'mountain view', NULL),
  (10, 315, TRUE,  4, 'garden view', NULL),
  (10, 365, FALSE, 5, 'city view', 'Noisy heater');

-- Rooms for Hotel_ID = 11
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (11, 270, TRUE,  1, 'city view', NULL),
  (11, 320, TRUE,  2, 'sea view', 'Faded wallpaper'),
  (11, 370, FALSE, 3, 'mountain view', NULL),
  (11, 295, TRUE,  4, 'garden view', NULL),
  (11, 345, FALSE, 5, 'city view', 'Minor plumbing issue');

-- Rooms for Hotel_ID = 12
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (12, 265, TRUE,  1, 'city view', NULL),
  (12, 315, TRUE,  2, 'sea view', 'Cracked window'),
  (12, 360, FALSE, 3, 'mountain view', NULL),
  (12, 285, TRUE,  4, 'garden view', NULL),
  (12, 335, FALSE, 5, 'city view', 'Faulty AC');

-- Rooms for Hotel_ID = 13
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (13, 275, TRUE,  1, 'city view', NULL),
  (13, 325, TRUE,  2, 'sea view', 'Minor scuff'),
  (13, 375, FALSE, 3, 'mountain view', NULL),
  (13, 300, TRUE,  4, 'garden view', NULL),
  (13, 350, FALSE, 5, 'city view', 'Dim lighting');

-- Rooms for Hotel_ID = 14
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (14, 280, TRUE,  1, 'city view', NULL),
  (14, 330, TRUE,  2, 'sea view', 'Small crack in door'),
  (14, 380, FALSE, 3, 'mountain view', NULL),
  (14, 305, TRUE,  4, 'garden view', NULL),
  (14, 355, FALSE, 5, 'city view', 'Faulty heater');

-- Rooms for Hotel_ID = 15
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (15, 285, TRUE,  1, 'city view', NULL),
  (15, 335, TRUE,  2, 'sea view', 'Minor paint chip'),
  (15, 385, FALSE, 3, 'mountain view', NULL),
  (15, 310, TRUE,  4, 'garden view', NULL),
  (15, 360, FALSE, 5, 'city view', 'Noisy AC');

-- Rooms for Hotel_ID = 16
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (16, 290, TRUE,  1, 'city view', NULL),
  (16, 340, TRUE,  2, 'sea view', 'Cracked tile'),
  (16, 390, FALSE, 3, 'mountain view', NULL),
  (16, 315, TRUE,  4, 'garden view', NULL),
  (16, 365, FALSE, 5, 'city view', 'Minor leak');



--=========================================
-- Rooms for the Hyatt Hotel 
--=========================================
-- Rooms for Hotel_ID = 17
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (17, 300, TRUE,  1, 'ocean view', NULL),
  (17, 350, TRUE,  2, 'city view', 'Minor scuff on door'),
  (17, 400, FALSE, 3, 'garden view', NULL),
  (17, 325, TRUE,  4, 'sea view', NULL),
  (17, 375, FALSE, 5, 'city view', 'Faulty AC');

-- Rooms for Hotel_ID = 18
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (18, 310, TRUE,  1, 'city view', NULL),
  (18, 360, TRUE,  2, 'ocean view', 'Scratched window'),
  (18, 410, FALSE, 3, 'garden view', NULL),
  (18, 335, TRUE,  4, 'sea view', NULL),
  (18, 385, FALSE, 5, 'city view', 'Noisy heater');

-- Rooms for Hotel_ID = 19
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (19, 320, TRUE,  1, 'city view', NULL),
  (19, 370, TRUE,  2, 'sea view', 'Minor leak'),
  (19, 420, FALSE, 3, 'ocean view', NULL),
  (19, 345, TRUE,  4, 'garden view', NULL),
  (19, 395, FALSE, 5, 'city view', 'Cracked tile');

-- Rooms for Hotel_ID = 20
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (20, 330, TRUE,  1, 'ocean view', NULL),
  (20, 380, TRUE,  2, 'city view', 'Faded wallpaper'),
  (20, 430, FALSE, 3, 'garden view', NULL),
  (20, 355, TRUE,  4, 'sea view', NULL),
  (20, 405, FALSE, 5, 'city view', 'Faulty heater');

-- Rooms for Hotel_ID = 21
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (21, 340, TRUE,  1, 'city view', NULL),
  (21, 390, TRUE,  2, 'ocean view', 'Minor scuff on wall'),
  (21, 440, FALSE, 3, 'garden view', NULL),
  (21, 365, TRUE,  4, 'sea view', NULL),
  (21, 415, FALSE, 5, 'city view', 'Temperature issues');

-- Rooms for Hotel_ID = 22
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (22, 350, TRUE,  1, 'city view', NULL),
  (22, 400, TRUE,  2, 'sea view', 'Cracked window'),
  (22, 450, FALSE, 3, 'ocean view', NULL),
  (22, 375, TRUE,  4, 'garden view', NULL),
  (22, 425, FALSE, 5, 'city view', 'Minor plumbing issue');

-- Rooms for Hotel_ID = 23
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (23, 360, TRUE,  1, 'ocean view', NULL),
  (23, 410, TRUE,  2, 'city view', 'Worn carpet'),
  (23, 460, FALSE, 3, 'garden view', NULL),
  (23, 385, TRUE,  4, 'sea view', NULL),
  (23, 435, FALSE, 5, 'city view', 'Faulty air conditioning');

-- Rooms for Hotel_ID = 24
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (24, 370, TRUE,  1, 'city view', NULL),
  (24, 420, TRUE,  2, 'ocean view', 'Minor door dent'),
  (24, 470, FALSE, 3, 'garden view', NULL),
  (24, 395, TRUE,  4, 'sea view', NULL),
  (24, 445, FALSE, 5, 'city view', 'Noisy AC');



--=========================================
-- Rooms for the Intercontinental Hotel 
--=========================================
-- Rooms for Hotel_ID = 25
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (25, 380, TRUE,  1, 'city view', NULL),
  (25, 430, TRUE,  2, 'sea view', 'Minor scuff on door'),
  (25, 480, FALSE, 3, 'mountain view', NULL),
  (25, 405, TRUE,  4, 'garden view', NULL),
  (25, 455, FALSE, 5, 'city view', 'AC rattling noise');

-- Rooms for Hotel_ID = 26
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (26, 385, TRUE,  1, 'city view', NULL),
  (26, 435, TRUE,  2, 'sea view', 'Faded wallpaper'),
  (26, 485, FALSE, 3, 'mountain view', NULL),
  (26, 410, TRUE,  4, 'garden view', 'Loose faucet handle'),
  (26, 460, FALSE, 5, 'city view', 'Minor leak near window');

-- Rooms for Hotel_ID = 27
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (27, 390, TRUE,  1, 'city view', NULL),
  (27, 440, TRUE,  2, 'sea view', 'Scratched window frame'),
  (27, 490, FALSE, 3, 'mountain view', NULL),
  (27, 415, TRUE,  4, 'garden view', NULL),
  (27, 465, FALSE, 5, 'city view', 'Noisy heater');

-- Rooms for Hotel_ID = 28
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (28, 395, TRUE,  1, 'city view', NULL),
  (28, 445, TRUE,  2, 'sea view', 'Cracked tile near door'),
  (28, 495, FALSE, 3, 'mountain view', 'Flickering light'),
  (28, 420, TRUE,  4, 'garden view', NULL),
  (28, 470, FALSE, 5, 'city view', 'AC not cooling well');

-- Rooms for Hotel_ID = 29
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (29, 400, TRUE,  1, 'city view', NULL),
  (29, 450, TRUE,  2, 'sea view', 'Minor paint peeling'),
  (29, 500, FALSE, 3, 'mountain view', NULL),
  (29, 425, TRUE,  4, 'garden view', 'Loose door handle'),
  (29, 475, FALSE, 5, 'city view', 'Occasional dripping noise');

-- Rooms for Hotel_ID = 30
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (30, 405, TRUE,  1, 'city view', NULL),
  (30, 455, TRUE,  2, 'sea view', 'Worn carpet'),
  (30, 505, FALSE, 3, 'mountain view', NULL),
  (30, 430, TRUE,  4, 'garden view', NULL),
  (30, 480, FALSE, 5, 'city view', 'Leaky shower head');

-- Rooms for Hotel_ID = 31
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (31, 410, TRUE,  1, 'city view', 'Loose curtain rod'),
  (31, 460, TRUE,  2, 'sea view', NULL),
  (31, 510, FALSE, 3, 'mountain view', 'Broken desk drawer'),
  (31, 435, TRUE,  4, 'garden view', NULL),
  (31, 485, FALSE, 5, 'city view', 'Intermittent Wi-Fi');

-- Rooms for Hotel_ID = 32
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (32, 415, TRUE,  1, 'city view', NULL),
  (32, 465, TRUE,  2, 'sea view', 'Loose hinge on closet door'),
  (32, 515, FALSE, 3, 'mountain view', NULL),
  (32, 440, TRUE,  4, 'garden view', 'Stained bedsheet'),
  (32, 490, FALSE, 5, 'city view', 'Weak water pressure');


--=========================================
-- Rooms for the Accor Hotel 
--=========================================
-- Rooms for Hotel_ID = 33
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (33, 420, TRUE,  1, 'city view', NULL),
  (33, 470, TRUE,  2, 'sea view', 'Minor scuff'),
  (33, 520, FALSE, 3, 'mountain view', NULL),
  (33, 445, TRUE,  4, 'garden view', NULL),
  (33, 495, FALSE, 5, 'city view', 'Faulty AC');

-- Rooms for Hotel_ID = 34
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (34, 430, TRUE,  1, 'city view', NULL),
  (34, 480, TRUE,  2, 'sea view', 'Faded paint'),
  (34, 530, FALSE, 3, 'mountain view', NULL),
  (34, 455, TRUE,  4, 'garden view', NULL),
  (34, 505, FALSE, 5, 'city view', 'Noisy heater');

-- Rooms for Hotel_ID = 35
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (35, 440, TRUE,  1, 'city view', NULL),
  (35, 490, TRUE,  2, 'sea view', 'Cracked tile'),
  (35, 540, FALSE, 3, 'mountain view', NULL),
  (35, 465, TRUE,  4, 'garden view', NULL),
  (35, 515, FALSE, 5, 'city view', 'Minor leak');

-- Rooms for Hotel_ID = 36
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (36, 450, TRUE,  1, 'city view', NULL),
  (36, 500, TRUE,  2, 'sea view', 'Small dent'),
  (36, 550, FALSE, 3, 'mountain view', NULL),
  (36, 475, TRUE,  4, 'garden view', NULL),
  (36, 525, FALSE, 5, 'city view', 'Minor plumbing issue');

-- Rooms for Hotel_ID = 37
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (37, 460, TRUE,  1, 'city view', NULL),
  (37, 510, TRUE,  2, 'sea view', 'Scratched window'),
  (37, 560, FALSE, 3, 'mountain view', NULL),
  (37, 485, TRUE,  4, 'garden view', NULL),
  (37, 535, FALSE, 5, 'city view', 'Faulty heater');

-- Rooms for Hotel_ID = 38
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (38, 470, TRUE,  1, 'city view', NULL),
  (38, 520, TRUE,  2, 'sea view', 'Minor scuff on door'),
  (38, 570, FALSE, 3, 'mountain view', NULL),
  (38, 495, TRUE,  4, 'garden view', NULL),
  (38, 545, FALSE, 5, 'city view', 'Noisy air conditioner');

-- Rooms for Hotel_ID = 39
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (39, 480, TRUE,  1, 'city view', NULL),
  (39, 530, TRUE,  2, 'sea view', 'Minor scuff'),
  (39, 580, FALSE, 3, 'mountain view', NULL),
  (39, 505, TRUE,  4, 'garden view', NULL),
  (39, 555, FALSE, 5, 'city view', 'Faulty AC');

-- Rooms for Hotel_ID = 40
INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) VALUES
  (40, 490, TRUE,  1, 'city view', NULL),
  (40, 540, TRUE,  2, 'sea view', 'Faded wallpaper'),
  (40, 590, FALSE, 3, 'mountain view', NULL),
  (40, 515, TRUE,  4, 'garden view', NULL),
  (40, 565, FALSE, 5, 'city view', 'Minor leak');



-- ========================================================
-- 5. Employee and Manager Data
-- ========================================================

-- Insert Employees (one manager per hotel; assuming 40 hotels, we add 40 managers)
INSERT INTO employee (SSN, full_name, address) VALUES
  (100001, 'Manager A', 'Address A'),
  (100002, 'Manager B', 'Address B'),
  (100003, 'Manager C', 'Address C'),
  (100004, 'Manager D', 'Address D'),
  (100005, 'Manager E', 'Address E'),
  (100006, 'Manager F', 'Address F'),
  (100007, 'Manager G', 'Address G'),
  (100008, 'Manager H', 'Address H'),
  (100009, 'Manager I', 'Address I'),
  (100010, 'Manager J', 'Address J'),
  (100011, 'Manager K', 'Address K'),
  (100012, 'Manager L', 'Address L'),
  (100013, 'Manager M', 'Address M'),
  (100014, 'Manager N', 'Address N'),
  (100015, 'Manager O', 'Address O'),
  (100016, 'Manager P', 'Address P'),
  (100017, 'Manager Q', 'Address Q'),
  (100018, 'Manager R', 'Address R'),
  (100019, 'Manager S', 'Address S'),
  (100020, 'Manager T', 'Address T'),
  (100021, 'Manager U', 'Address U'),
  (100022, 'Manager V', 'Address V'),
  (100023, 'Manager W', 'Address W'),
  (100024, 'Manager X', 'Address X'),
  (100025, 'Manager Y', 'Address Y'),
  (100026, 'Manager Z', 'Address Z'),
  (100027, 'Manager AA', 'Address AA'),
  (100028, 'Manager BB', 'Address BB'),
  (100029, 'Manager CC', 'Address CC'),
  (100030, 'Manager DD', 'Address DD'),
  (100031, 'Manager EE', 'Address EE'),
  (100032, 'Manager FF', 'Address FF'),
  (100033, 'Manager GG', 'Address GG'),
  (100034, 'Manager HH', 'Address HH'),
  (100035, 'Manager II', 'Address II'),
  (100036, 'Manager JJ', 'Address JJ'),
  (100037, 'Manager KK', 'Address KK'),
  (100038, 'Manager LL', 'Address LL'),
  (100039, 'Manager MM', 'Address MM'),
  (100040, 'Manager NN', 'Address NN');

-- Insert Employee Roles (assigning the "Manager" role)
INSERT INTO employee_role (employee_ID, role) VALUES
  (1, 'Manager'),
  (2, 'Manager'),
  (3, 'Manager'),
  (4, 'Manager'),
  (5, 'Manager'),
  (6, 'Manager'),
  (7, 'Manager'),
  (8, 'Manager'),
  (9, 'Manager'),
  (10, 'Manager'),
  (11, 'Manager'),
  (12, 'Manager'),
  (13, 'Manager'),
  (14, 'Manager'),
  (15, 'Manager'),
  (16, 'Manager'),
  (17, 'Manager'),
  (18, 'Manager'),
  (19, 'Manager'),
  (20, 'Manager'),
  (21, 'Manager'),
  (22, 'Manager'),
  (23, 'Manager'),
  (24, 'Manager'),
  (25, 'Manager'),
  (26, 'Manager'),
  (27, 'Manager'),
  (28, 'Manager'),
  (29, 'Manager'),
  (30, 'Manager'),
  (31, 'Manager'),
  (32, 'Manager'),
  (33, 'Manager'),
  (34, 'Manager'),
  (35, 'Manager'),
  (36, 'Manager'),
  (37, 'Manager'),
  (38, 'Manager'),
  (39, 'Manager'),
  (40, 'Manager');

-- Map each manager to a hotel 
INSERT INTO manager (employee_ID, hotel_ID) VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5),
  (6, 6),
  (7, 7),
  (8, 8),
  (9, 9),
  (10, 10),
  (11, 11),
  (12, 12),
  (13, 13),
  (14, 14),
  (15, 15),
  (16, 16),
  (17, 17),
  (18, 18),
  (19, 19),
  (20, 20),
  (21, 21),
  (22, 22),
  (23, 23),
  (24, 24),
  (25, 25),
  (26, 26),
  (27, 27),
  (28, 28),
  (29, 29),
  (30, 30),
  (31, 31),
  (32, 32),
  (33, 33),
  (34, 34),
  (35, 35),
  (36, 36),
  (37, 37),
  (38, 38),
  (39, 39),
  (40, 40);
-- ==============================
-- 1. Customer Data (4 customers)
-- ==============================
INSERT INTO customer (SSN, full_name, address, registration_date) VALUES
  ('111-22-3333', 'John Doe', '123 Main St, New York, NY', '2025-01-10'),
  ('444-55-6666', 'Jane Smith', '456 Oak Ave, Chicago, IL', '2025-02-20'),
  ('777-88-9999', 'Alice Johnson', '789 Pine Rd, Miami, FL', '2025-03-15'),
  ('999-88-7777', 'Bob Williams', '1010 Ocean Blvd, Seattle, WA', '2025-04-01');

-- ==============================
-- 2. Booking Data (3 bookings)
-- ==============================

INSERT INTO booking (status, booking_date, check_in_date, check_out_date) VALUES
  ('Reserved', '2025-05-01', '2025-05-10', '2025-05-12'),
  ('Canceled', '2025-05-03', '2025-05-15', '2025-05-17'),
  ('Reserved', '2025-05-05', '2025-05-20', '2025-05-25');

-- ==============================
-- 3. Books Data
-- ==============================
-- booking_ID 1 => customer_ID 1 => room_ID 1
-- booking_ID 1 => customer_ID 2 => room_ID 2
-- booking_ID 2 => customer_ID 3 => room_ID 3
-- booking_ID 3 => customer_ID 4 => room_ID 5
INSERT INTO books (booking_ID, customer_ID, room_ID) VALUES
  (1, 1, 1),
  (1, 2, 2),
  (2, 3, 3),
  (3, 4, 5);

-- ==============================
-- 4. Renting Data
-- ==============================
-- Suppose 2 rentals occurred:
INSERT INTO renting (customer_ID, room_ID, employee_ID, check_in_date, check_out_date, status) VALUES
  (1, 1, 1, '2025-05-10', '2025-05-12', 'Completed'),
  (1, 1, 1, '2025-05-20', '2025-05-25', 'Ongoing');

-- ==============================
-- 5. Archive Data
-- ==============================
INSERT INTO archive (date, type) VALUES
  ('2025-06-01', 'Booking'),
  ('2025-06-01', 'Renting');

-- ==============================
-- 6. Archives Data
-- ==============================
-- Suppose we archive booking_ID=1 & renting_ID=1 under archive_ID=1
-- and booking_ID=2 & renting_ID=2 under archive_ID=2
INSERT INTO archives (archive_ID, renting_ID, booking_ID) VALUES
  (1, 1, 1),
  (2, 2, 2);
-- ==============================
-- 7. ChecksIn Data
-- ==============================
-- Let’s say John Doe (customer_ID=1) physically checks into room_ID=1,
-- an employee processed it (employee_ID=1 => 'Manager A'),
-- referencing booking_ID=1, on 2025-05-10
INSERT INTO checks_in (customer_ID, room_ID, employee_ID, check_in_date, booking_ID)
VALUES (1, 1, 1, '2025-05-10', 1);

-- Another example: Jane Smith (customer_ID=2) is a walk-in (no booking)
INSERT INTO checks_in (customer_ID, room_ID, employee_ID, check_in_date)
VALUES (2, 2, 2, '2025-05-09');



-- Sample Room Amenities (100 entries)
INSERT INTO room_amenity (room_ID, amenity) VALUES
(1, 'WiFi'),(1, 'Air Conditioning'),
(2, 'Mini Bar'),(2, 'TV'),
(3, 'WiFi'),(3, 'Balcony'),
(4, 'Air Conditioning'),(4, 'Room Service'),
(5, 'WiFi'),(5, 'Coffee Maker'),
(6, 'TV'),(6, 'Mini Bar'),(7, 'WiFi'),
(7, 'Hair Dryer'),
(8, 'Safe'),(8, 'Room Service'),
(9, 'TV'),(9, 'WiFi'),
(10, 'Coffee Maker'),(10, 'Balcony'),
(11, 'Air Conditioning'),(11, 'Hair Dryer'),
(12, 'Mini Bar'),(12, 'WiFi'),
(13, 'TV'),(13, 'Balcony'),
(14, 'Safe'),
(14, 'WiFi'),
(15, 'Air Conditioning'),
(15, 'Mini Bar'),
(16, 'Room Service'),
(16, 'TV'),
(17, 'WiFi'),
(17, 'Coffee Maker'),
(18, 'TV'),
(18, 'Hair Dryer'),
(19, 'WiFi'),
(19, 'Mini Bar'),
(20, 'Safe'),
(20, 'Room Service'),
(21, 'Balcony'),
(21, 'TV'),
(22, 'WiFi'),
(22, 'Air Conditioning'),
(23, 'Coffee Maker'),
(23, 'Hair Dryer'),
(24, 'Mini Bar'),
(24, 'Room Service'),
(25, 'WiFi'),
(25, 'TV'),
(26, 'Air Conditioning'),
(26, 'Safe'),
(27, 'Mini Bar'),
(27, 'Balcony'),
(28, 'WiFi'),
(28, 'Coffee Maker'),
(29, 'TV'),
(29, 'Room Service'),
(30, 'Hair Dryer'),
(30, 'Mini Bar'),
(31, 'WiFi'),
(31, 'Air Conditioning'),
(32, 'Safe'),
(32, 'Coffee Maker'),
(33, 'TV'),
(33, 'Balcony'),
(34, 'Mini Bar'),
(34, 'WiFi'),
(35, 'Air Conditioning'),
(35, 'Room Service'),
(36, 'Hair Dryer'),
(36, 'TV'),
(37, 'WiFi'),
(37, 'Mini Bar'),
(38, 'Coffee Maker'),
(38, 'Safe'),
(39, 'Balcony'),
(39, 'TV'),
(40, 'Room Service'),
(40, 'WiFi'),
(41, 'Hair Dryer'),
(41, 'Air Conditioning'),
(42, 'Mini Bar'),
(42, 'TV'),
(43, 'WiFi'),
(43, 'Balcony'),
(44, 'Room Service'),
(44, 'Coffee Maker'),
(45, 'TV'),
(45, 'Safe'),
(46, 'WiFi'),
(46, 'Mini Bar'),
(47, 'Hair Dryer'),
(47, 'Air Conditioning'),
(48, 'Room Service'),
(48, 'Coffee Maker'),
(49, 'TV'),
(49, 'WiFi'),
(50, 'Mini Bar'),
(50, 'Balcony');
