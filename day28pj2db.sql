DROP DATABASE IF EXISTS day28pj2;
CREATE DATABASE day28pj2;
USE day28pj2;

CREATE TABLE inventory(
    no INT,
    CONSTRAINT PRIMARY KEY(no),
    menuName VARCHAR(255)
);

INSERT INTO inventory(no, menuName) VALUES
(1, '투움바 파스타'),
(2, '베이비 백 립'),
(3, '블랙라벨 스테이크'),
(4, '갈릭 립아이'),
(5, '퀸즈랜드 립아이'),
(6, '치킨 텐더 샐러드'),
(7, '오지 치즈 후라이즈'),
(8, '골드 코스트 코코넛 쉬림프'),
(9, '스파이시 씨푸드 알리오 올리오'),
(10, '초콜릿 썬더 프롬 다운 언더');

CREATE TABLE stock(
    no INT,
    menuQty INT UNSIGNED,
    CONSTRAINT PRIMARY KEY(no),
    CONSTRAINT FOREIGN KEY(no) REFERENCES inventory(no)
);

INSERT INTO stock(no, menuQty) VALUES
(1, 8),
(2, 5),
(3, 4),
(4, 7),
(5, 3),
(6, 10),
(7, 6),
(8, 4),
(9, 9),
(10, 2);


CREATE TABLE request(
    no INT,
    requestQty INT UNSIGNED,
    CONSTRAINT PRIMARY KEY(no),
    CONSTRAINT FOREIGN KEY(no) REFERENCES inventory(no)
);

INSERT INTO request(no, requestQty) VALUES
(1, 10),
(2, 8),
(3, 6),
(4, 5),
(5, 5),
(6, 8),
(7, 10),
(8, 7),
(9, 6),
(10, 5);


CREATE TABLE REVIEW(
    REIVNO INT PRIMARY KEY AUTO_INCREMENT,
    MNO INT,
    RCONTENT varchar(255) NOT NULL,
    SCOPE INT NOT NULL,

    CONSTRAINT FOREIGN KEY(MNO) REFERENCES INVENTORY(`NO`)
);

INSERT INTO REVIEW (MNO, RCONTENT, SCOPE) VALUES
(1, '투움바 파스타 크림소스 진하고 맛있어요.', 5),
(2, '베이비 백 립 살이 부드럽게 발라져요.', 5),
(3, '블랙라벨 스테이크 육즙 대박!', 5),
(4, '갈릭 립아이 마늘향 완벽해요.', 4),
(5, '퀸즈랜드 립아이 굽기 딱 맞았어요.', 4),
(6, '치킨 텐더 샐러드 든든하고 신선해요.', 4),
(7, '오지 치즈 후라이즈 자꾸 손이 가요.', 5),
(8, '코코넛 쉬림프 바삭하고 달콤해요.', 4),
(9, '씨푸드 알리오 올리오 살짝 매콤 굿.', 3),
(10, '초콜릿 썬더 디저트로 최고예요!', 5);


create table reservation(
    reservNo int unsigned auto_increment,
    constraint primary key (reservNo),
    telNo varchar(255),
    people int
);
INSERT INTO reservation (telNo, people) VALUES ('010-1234-5678', 2);
INSERT INTO reservation (telNo, people) VALUES ('010-2345-6789', 4);
INSERT INTO reservation (telNo, people) VALUES ('010-3456-7890', 1);
INSERT INTO reservation (telNo, people) VALUES ('010-4567-8901', 3);
INSERT INTO reservation (telNo, people) VALUES ('010-5678-9012', 6);
INSERT INTO reservation (telNo, people) VALUES ('010-6789-0123', 2);
INSERT INTO reservation (telNo, people) VALUES ('010-7890-1234', 5);
INSERT INTO reservation (telNo, people) VALUES ('010-8901-2345', 2);
INSERT INTO reservation (telNo, people) VALUES ('010-9012-3456', 4);
INSERT INTO reservation (telNo, people) VALUES ('010-0123-4567', 3);

cReAtE tAbLe OrDeRs(
   no int AUTO_INCREMENT,
   constraint primary key(no),
   mno int,
   constraint foreign key(mno) references inventory(no),
   amount int,
   pname varchar(30)
);

iNsErT iNtO OrDeRs(mno, amount, pname) Values
(1, 4, "자르반97세의마지막한타"),
(1, 3, "야스오"),
(3, 1, "야스오형"),
(2, 4, "카타리나");


select * from orders;
select * from orders join inventory on orders.mno = inventory.no;

update orders set mno = 1, amount = 4 where no = 1;

iNsErT iNtO OrDeRs(mno, amount, pname) Values
(3, 1, "테스트");
DELETE from orders where no = 5;

select inventory.no, menuName, menuqty from inventory join stock on inventory.no = stock.no GROUP BY no having menuqty>0;