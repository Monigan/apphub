-- Create roles
CREATE USER storage WITH ENCRYPTED PASSWORD 'storage';
CREATE USER core WITH ENCRYPTED PASSWORD 'core';

-- Create databases
CREATE DATABASE storage OWNER storage;
CREATE DATABASE core OWNER core;
