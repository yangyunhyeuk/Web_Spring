select * from all_tables;

drop table board;
drop table member;

select * from member;
select * from board;


create table board(
   id int primary key,
   title varchar(30),
   writer varchar(15),
   content varchar(100),
   wdate date default sysdate
);
create table member(
   id varchar(15) primary key,
   password varchar(10),
   name varchar(15),
   role varchar(15)
);
insert into member values('kim','1234','辫揪','USER');
insert into member values('admin','1234','包府磊','ADMIN');

insert into board (id,title,writer,content) values(1,'力格','辫揪','臂 郴侩');

delete from board where title='力格涝聪促!';


insert into board (id, title, writer, content, wdate) values(, ?, ?, ?, ?);


SELECT * FROM BOARD WHERE title LIKE '%格%' ORDER BY ID DESC


INSERT INTO MEMBER (id, password, name, role) VALUES('1','2','3','4')


INSERT INTO BOARD (id, title, writer, content) VALUES((SELECT NVL(MAX(ID),0)+1 from BOARD), '1', '2', '3')
insert into board (id,title,writer,content)           values((select nvl(max(id),0)+1 from board),?,?,?)



INSERT INTO MEMBER (id, password, name, role) VALUES('6', '2', '3', '4');












