create schema NewSchema;
use NewSchema;

CREATE TABLE PunchedTime (
    id INT AUTO_INCREMENT PRIMARY KEY,
    punchedtime DATETIME,
    employeeid INT,
    isoutpunch BOOLEAN,
    processed BOOLEAN,
    punchtype INT,
    ipaddr VARCHAR(255)
);

CREATE TABLE PunchedIN (
    id INT AUTO_INCREMENT PRIMARY KEY,
    punchedtime DATETIME,
    employeeid INT,
    isoutpunch BOOLEAN,
    processed BOOLEAN,
    punchtype INT,
    ipaddr VARCHAR(255)
);

CREATE TABLE PunchedOUT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    punchedtime DATETIME,
    employeeid INT,
    isoutpunch BOOLEAN,
    processed BOOLEAN,
    punchtype INT,
    ipaddr VARCHAR(255)
);

CREATE TABLE shift_table (id INT AUTO_INCREMENT primary key, sid INT,shiftname VARCHAR(50), in_time TIME,out_time TIME);


CREATE TABLE IF NOT EXISTS merged_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employeeid INT,
    punchedtime_in DATETIME,
    punchtype_in INT,
    ipaddr_in VARCHAR(255),
	punchedtime_out DATETIME,
    punchtype_out INT,
    ipaddr_out VARCHAR(255),
    in_time VARCHAR(255),
    out_time VARCHAR(255),
    shiftname VARCHAR(255)
);


-- Insert to merge
INSERT INTO merged_table (employeeid, punchedtime_in, punchtype_in, ipaddr_in, punchedtime_out, punchtype_out, ipaddr_out) 
select t1.employeeid as employeeid,t1.punchedtime as punchedtime_in,t1.punchtype as punchtype_in,t1.ipaddr as ipaddr_in,t2.punchedtime as punchedtime_out,t2.punchtype as punchtype_out,t2.ipaddr as ipaddr_out from punchedin t1 join punchedout t2 on t1.employeeid = t2.employeeid ;


select * from punchedtime;
select * from punchedin;
select * from punchedout;
select * from shift_table;