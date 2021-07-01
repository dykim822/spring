** tableList 
**memberTable
drop table member;
select * from member;
create table member (
	mId			varchar2(40),
 	password	varchar2(40),
 	mName		varchar2(40),
 	postcode	varchar2(20),
	address		varchar2(50),
 	email		varchar2(50),
 	job			varchar2(30),
 	PRIMARY KEY (mId)
);
-- 관리자
insert into member(mid,password) values('master','master');
update member set mName='대박이' where mId='master';
select * from member where mid='master';
**product Table
select * from board;
drop table product cascade constraint;
create table product(
 	pId				number(5) primary key,
 	pName			varchar2(40),
 	price			number(10),
 	description 	varchar2(100),
 	picUrl			varchar2(40), 
 	rangeCode		number(5),
 	mdCode			number(5),
 	voteCode		number(5),
 	hit				number(5),
 	regdate			DATE,
 	quantity        number(5) -- 재고
);
update product set quantity =100;
drop sequence pId_seq;
-- sequence는 자동으로 1씩 증가
create sequence pId_seq;
select * from product;

-- **locTable -- 켐핑장이 있는 위치 
create table loc(
 	locCode		number(5),
 	locName		varchar2(40),
 	locUrl		varchar2(40),
 	PRIMARY KEY (locCode)
);	
select * from loc;

INSERT INTO LOC VALUES(0,'서울시','seoul.jpg');
INSERT INTO LOC VALUES(1,'경기도','gg.jpg');
INSERT INTO LOC VALUES(2,'강원도','gang.jpg');
INSERT INTO LOC VALUES(3,'충청도','cc.jpg');
INSERT INTO LOC VALUES(4,'전라도','jr.jpg');
INSERT INTO LOC VALUES(5,'경상도','gs.jpg');
INSERT INTO LOC VALUES(6,'제주도','jeju.jpg');
INSERT INTO LOC VALUES(100,'전체','map.jpg');

select * from loc;

**campsite Table
drop table campsite;
create table campsite(
	sId			number(5),
 	sName		varchar2(40),
 	address		varchar2(50),
 	phone		varchar2(40),
 	home		varchar2(200),
 	picUrl		varchar2(100),
 	locCode		number(5),
 	reservation number(1),   -- 1 예약완료,0 예약가능
 	PRIMARY KEY (sId),
 	FOREIGN KEY (locCode) REFERENCES loc (locCode) 
);
alter table campsite modify(home varchar2(200));
--  alter table campsite add (reservation number(1));
-- update campsite set reservation=0;
create sequence sId_seq;
-- 캠핑장 키를 자동으로 1씩 증가
--start with 1 
--	increment by 1 	nocycle nocache;
drop sequence sId_seq;
select * from campsite;

**board Table
drop table board5;
-- bCode 전체, 요리, 질의, 후기, 자유게시
create table board5 ( 
	bId			number(5),
 	writer		varchar2(40),
 	title		varchar2(40),
 	content		varchar2(100),
 	regdate		DATE,
 	hit			number(5),
 	bCode 		varchar2(40),
 	PRIMARY KEY (bId)
 );
 select * from board5;
 -- 게시판 번호를 자동으로1씩 증가
create sequence bId_seq;
select * from board5 where bcode='free';

** shortboard Table
drop table shortboard;
-- 댓글 게시
create table shortboard(
 	pId			number(5),
 	writer		varchar2(40),
 	sbId		number(5),
 	content		varchar2(100),
 	regdate 	DATE,
 	PRIMARY KEY (sbId),
 	FOREIGN KEY (pId) REFERENCES product (pId) 
);
drop sequence sbId_seq;
-- 댓글 게시 pk에 자동으로1씩 증가
create sequence sbId_seq; 
select * from shortboard;


**sale Table
select * from sale;
drop table sale;
-- 판매
create table sale(
 	saleId		number(10) ,
 	mId			varchar2(40) REFERENCES member (mId) ,
 	updateTime	TIMESTAMP,
 	PRIMARY KEY (saleId, mId) -- 두개의 컬럼을 합쳐서 하나의 primary key	
);
select * from sale;
**saleline Table
delete from sale;
drop table saleline;
-- 상세 판매 내역
create table saleline(
	saleId		number(10),
 	salelineId	number(5),
 	pId			number(5),
 	quantity	number(1),
 	updateTime	TIMESTAMP,
 	PRIMARY KEY (saleId, salelineId), 
	FOREIGN KEY (pId) REFERENCES product (pId)
);
select * from saleline;
 