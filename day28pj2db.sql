DROP DATABASE IF EXISTS day28pj2;
CREATE DATABASE day28pj2;
USE day28pj2;

CREATE TABLE inventory(
    no int,
    CONSTRAINT PRIMARY KEY(no),
    menuName varchar(255),
    menuQty int UNSIGNED,
    requestQty int UNSIGNED
);
INSERT INTO inventory(no, menuName, menuQty, requestQty) VALUES
(1, '투움바 파스타', 8, 10),
(2, '베이비 백 립', 5, 8),
(3, '블랙라벨 스테이크', 4, 6),
(4, '갈릭 립아이', 7, 5),
(5, '퀸즈랜드 립아이', 3, 5),
(6, '치킨 텐더 샐러드', 10, 8),
(7, '오지 치즈 후라이즈', 6, 10),
(8, '골드 코스트 코코넛 쉬림프', 4, 7),
(9, '스파이시 씨푸드 알리오 올리오', 9, 6),
(10, '초콜릿 썬더 프롬 다운 언더', 2, 5);


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