SELECT * FROM ALL_TABLES;

select * from all_tables;

create table board(
   id int primary key,
   title varchar(30),
   writer varchar(15),
   content varchar(100),
   wdate date default sysdate
);
create table bmember(
   id varchar(15) primary key,
   password varchar(10),
   name varchar(15),
   role varchar(15)
);
insert into bmember values('kim','1234','�达','USER');
insert into bmember values('admin','1234','������','ADMIN');
select * from bmember;
insert into board (id,title,writer,content) values(1,'����','�达','�� ����');
select * from board;
drop table board;

