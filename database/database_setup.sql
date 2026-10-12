-- Database Setup for Bank Management System (MySQL)
CREATE DATABASE IF NOT EXISTS bankmanagementsystem;
USE bankmanagementsystem;

CREATE TABLE IF NOT EXISTS signup (
    formno VARCHAR(20),
    name VARCHAR(50),
    fname VARCHAR(50),
    dob VARCHAR(30),
    gender VARCHAR(20),
    email VARCHAR(50),
    marital VARCHAR(20),
    address VARCHAR(100),
    city VARCHAR(50),
    pin VARCHAR(20),
    state VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS signuptwo (
    formno VARCHAR(20),
    religion VARCHAR(30),
    category VARCHAR(30),
    income VARCHAR(30),
    education VARCHAR(30),
    occupation VARCHAR(30),
    pan VARCHAR(30),
    aadhar VARCHAR(30),
    seniorcitizon VARCHAR(20),
    existingaccount VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS signupthree (
    formno VARCHAR(20),
    accountType VARCHAR(40),
    cardnumber VARCHAR(30),
    pin VARCHAR(10),
    facility VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS login (
    formno VARCHAR(20),
    cardnumber VARCHAR(30),
    pin VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS bank (
    pin VARCHAR(10),
    date VARCHAR(50),
    type VARCHAR(30),
    amount VARCHAR(30)
);

-- Demo user account
INSERT INTO login VALUES ('1001', '5040936012345678', '1234');
INSERT INTO signupthree VALUES ('1001', 'Saving Account', '5040936012345678', '1234', 'ATM Card, Internet Banking');
INSERT INTO bank VALUES ('1234', '2026-10-12', 'Deposit', '10000');
