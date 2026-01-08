-- Drop tables if they exist to ensure a clean start
DROP TABLE IF EXISTS users;

-- Create Users table
CREATE TABLE IF NOT EXISTS users (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     name VARCHAR(255) NOT NULL,
     surname VARCHAR(255) NOT NULL,
     email VARCHAR(255) UNIQUE NOT NULL,
     role VARCHAR(50) NOT NULL,
     password VARCHAR(255) NOT NULL
 );

-- other tables.


