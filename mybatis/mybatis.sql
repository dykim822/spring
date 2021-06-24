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

-- 하나의 ID에 여러개의 사진을 저장할 수 없으므로 table을 따로 생성
create table memberPhoto (
	num number(10) primary key,
	id varchar2(20) references member4(id),
	fileName varchar2(50)
);

-- memberPhoto의 primary key에 자동으로 1증가
create sequence memberPhoto_seq;
--sql developer에서 처리해줘야 함 -> sequence function은 생성 불가
create or replace function get_seq
	return number
is
begin
	return memberPhoto_seq.nextval;
end;
/
-----
select * from member4;
select * from memberPhoto;
