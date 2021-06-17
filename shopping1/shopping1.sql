create sequence item_seq;
create table item(
itemId number(5) ,
itemName varchar2(20),
price number(6),
description varchar2(100),
pictureUrl varchar2(20),
primary key (itemId)
);

insert into item values(item_seq.nextval,'레몬',50,'피로회복에 좋고 비타민 C도 풍부','lemon.jpg');
insert into item values(item_seq.nextval,'오렌지',100,'비타민 C가 풍부하고 생과일 주스로 마심.','orange.jpg');
insert into item values(item_seq.nextval,'키위',200,'비타민 C가 풍부하여 다이어트나 미용','kiui.jpg');
insert into item values(item_seq.nextval,'딸기',300,'폴리페놀을 다량 함유하고 있어 항산화 작용', 'ichigo.jpg'); 
insert into item values(item_seq.nextval,'포도',800,'비타민 C나 플라보노이드를 다량 함유', 'budou.jpg');
insert into item values(item_seq.nextval,'귤',1000,'시네피린을 함유하고 있어 감기 예방','mikan.jpg');

select * from item;

select * from dept;