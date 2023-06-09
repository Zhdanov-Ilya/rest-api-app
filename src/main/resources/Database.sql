CREATE TABLE Sensor (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(30) NOT NULL UNIQUE,
    registered_at timestamp NOT NULL
);

CREATE TABLE Measurement(
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    raining boolean NOT NULL ,
    measurement_date_time timestamp NOT NULL ,
    sensor varchar(100) references Sensor(name)
);