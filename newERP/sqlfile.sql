CREATE TABLE `shiftnames` (
  `sid` int DEFAULT NULL,
  `statTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL,
  `shiftName` varchar(100) DEFAULT NULL
) ;


CREATE TABLE raw_data_table (id INT AUTO_INCREMENT primary key, Eid INT, direction ENUM('in', 'out'),captureTime DATETIME, status BOOLEAN, capturedevice VARCHAR(50));

CREATE TABLE IF NOT EXISTS merged_tableinShift (
    id INT AUTO_INCREMENT PRIMARY KEY,
    eid INT,
    direction_in VARCHAR(3),
    captureTime_in DATETIME,
    status_in INT,
    capturedevice_in VARCHAR(50),
    direction_out VARCHAR(3),
    captureTime_out DATETIME,
    status_out INT,
    capturedevice_out VARCHAR(50),
    in_time VARCHAR(50),
     out_time VARCHAR(50),
     shiftname VARCHAR(50)
);

-- insert logic
INSERT INTO merged_table (eid, direction_in, captureTime_in, status_in, capturedevice_in, direction_out, captureTime_out, status_out, capturedevice_out)
SELECT t1.eid,
       t1.direction AS direction_in,
       t1.capture_time AS captureTime_in,
       t1.status AS status_in,
       t1.capture_device AS capturedevice_in,
       t2.direction AS direction_out,
       t2.capture_time AS captureTime_out,
       t2.status AS status_out,
       t2.capture_device AS capturedevice_out
FROM in_data t1
JOIN out_data t2 ON t1.eid = t2.eid and t1.id = t2.id;
