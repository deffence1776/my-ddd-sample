--プログラム
DROP TABLE IF EXISTS program;
CREATE TABLE IF NOT EXISTS program
(
    program_code        varchar(10) primary key,
    program_name        varchar(30)  not null,
    program_description varchar(100) not null,
    start_date date  not null ,
    end_date date not null,
    is_open boolean not null
);

--開催
DROP TABLE IF EXISTS holding;
CREATE TABLE IF NOT EXISTS holding
(
    holding_id             integer,
    program_code           varchar(10) not null,
    venue_code             varchar(10) not null,
    holding_startDate      date        not null,
    holding_startTime      time        not null,
    holding_endTime        time        not null,
    holding_openTimeMargin integer     not null,
    max_capacity           integer     not null,
    PRIMARY KEY (holding_id),
    UNIQUE (program_code, venue_code, holding_startDate, holding_startTime)
);

--会場
DROP TABLE IF EXISTS venue;
CREATE TABLE IF NOT EXISTS venue
(
    venue_code varchar(10) not null primary key,
    venue_name VARCHAR(30) not null
);


--チケット
DROP TABLE IF EXISTS ticket;
CREATE TABLE IF NOT EXISTS ticket
(
    ticket_code            varchar(30),
    holding_id             integer     not null,
    ticket_name            VARCHAR(20) not null,
    ticket_price           INTEGER     NOT NULL,
    ticket_capacity        INTEGER     NOT NULL,
    ticket_boundary_to_warn integer NOT NULL ,
    PRIMARY KEY (ticket_code)
);

--チケット予約
DROP TABLE IF EXISTS ticket_reservation;
DROP SEQUENCE IF EXISTS reservation_id_seq;

CREATE SEQUENCE reservation_id_seq;
CREATE TABLE IF NOT EXISTS ticket_reservation
(
    reservation_id        integer,
    ticket_code           varchar(30) not null ,
    reservation_timestamp timestamp not null,
    ticket_reservation_num INTEGER     NOT NULL,
    username varchar(30) not null,
    PRIMARY KEY (reservation_id)
);

--チケット在庫
DROP TABLE IF EXISTS ticket_stock;
CREATE TABLE IF NOT EXISTS ticket_stock
(
    ticket_stock_id integer,
    ticket_code varchar(30) not null,
    PRIMARY KEY (ticket_stock_id,ticket_code)
);

--座席


