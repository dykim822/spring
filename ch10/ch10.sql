drop table replyBoard;
create table replyBoard (
	rno number primary key,
	bno number not null references board(num),
	replytext varchar2(500) not null,
	replyer varchar2(50) not null,
	regdate date not null,
	updatedate date not null,
	del char(1)
);

select * from board order by num desc;
insert into replyBoard values(1, 250, '수요일', '영희', sysdate, sysdate, 'n');
insert into replyBoard values(2, 250, '날씨 어떄?', '민수', sysdate, sysdate, 'n');
insert into replyBoard values(3, 250, '날씨 어떄?', '홍길동', sysdate, sysdate, 'n');
select * from replyBoard;