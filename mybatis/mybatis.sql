create table member4 (
	id varchar2(20) primary key,
	email varchar2(30),
	password varchar2(30),
	name varchar2(30),
	fileName varchar2(50),
	del char(1) default 'n',
	regdate date
);

select * from member4;