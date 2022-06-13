-- Create roles
CREATE USER storage WITH ENCRYPTED PASSWORD 'storage';

-- Create databases
CREATE DATABASE storage OWNER storage;
