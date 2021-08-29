create database assignment6;
use assignment6;
CREATE TABLE 'accounts' (
'accountNo' int(5) NOT NULL AUTO_INCREMENT,
'balance' int(8) NOT NULL,
'branch' varchar(20) NOT NULL,
'type' varchar(20) NOT NULL,
PRIMARY KEY ('accountNo')
);