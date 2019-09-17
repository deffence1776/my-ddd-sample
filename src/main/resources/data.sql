DELETE FROM ticket_stock;
DELETE FROM ticket;
DELETE FROM venue;
DELETE FROM holding;
DELETE FROM program;


--プログラム
INSERT INTO  program VALUES('001','真夏の夜の夢','楽しいやつだよ','2019-11-01','2019-11-30',true);
INSERT INTO  program VALUES('002','リア王','悲しいやつだよ','2019-9-01','2019-11-01',true);
INSERT INTO  program VALUES('003','マクベス','悲しいやつだよ','2018-11-01','2018-11-01',true);
INSERT INTO  program VALUES('004','お気に召すまま','楽しいやつだよ','2018-11-01','2018-11-01',false);

--開催
INSERT INTO  holding VALUES(1,'001','001','2019-11-01','19:00','22:00',60,100);
INSERT INTO  holding VALUES(2,'001','001','2019-11-02','19:00','22:00',60,100);

--会場
INSERT INTO venue VALUES ('001','芸術劇場-シアターA');

--チケット

INSERT INTO  ticket VALUES('T001',1,'1等席',3000,10,5);
INSERT INTO  ticket VALUES('T002',1,'2等席',2000,10,5);

--TicketBean Stock

INSERT INTO  ticket_stock VALUES(1,'T001');
INSERT INTO  ticket_stock VALUES(2,'T001');
INSERT INTO  ticket_stock VALUES(3,'T001');
INSERT INTO  ticket_stock VALUES(4,'T001');
INSERT INTO  ticket_stock VALUES(5,'T001');
INSERT INTO  ticket_stock VALUES(6,'T001');
INSERT INTO  ticket_stock VALUES(7,'T001');
INSERT INTO  ticket_stock VALUES(8,'T001');
INSERT INTO  ticket_stock VALUES(9,'T001');
INSERT INTO  ticket_stock VALUES(10,'T001');

INSERT INTO  ticket_stock VALUES(1,'T002');
INSERT INTO  ticket_stock VALUES(2,'T002');
INSERT INTO  ticket_stock VALUES(3,'T002');
INSERT INTO  ticket_stock VALUES(4,'T002');
INSERT INTO  ticket_stock VALUES(5,'T002');
INSERT INTO  ticket_stock VALUES(6,'T002');
INSERT INTO  ticket_stock VALUES(7,'T002');
INSERT INTO  ticket_stock VALUES(8,'T002');
INSERT INTO  ticket_stock VALUES(9,'T002');
INSERT INTO  ticket_stock VALUES(10,'T002');



--座席


