select * from all_tables;

drop table board;
drop table member;


select * from member;
select * from board;

select * from board

SELECT * FROM MEMBER WHERE ID='hana' and password='11';

INSERT INTO MEMBER VALUES('dodo','do','do','do')


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
insert into member values('hana','11','하나','USER');
insert into member values('dool','22','두울','ADMIN');

insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');
insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),'제목1','작자2','내용3');

insert into board (id,title,writer,content) values(1,'����','�达','�� ����');

 

delete from board where title='�����Դϴ�!';


insert into board (id, title, writer, content, wdate) values(, ?, ?, ?, ?);


SELECT * FROM BOARD WHERE title LIKE '%��%' ORDER BY ID DESC


INSERT INTO MEMBER (id, password, name, role) VALUES('1','2','3','4')


INSERT INTO BOARD (id, title, writer, content) VALUES((SELECT NVL(MAX(ID),0)+1 from BOARD), '1', '2', '3')
insert into board (id,title,writer,content)           values((select nvl(max(id),0)+1 from board),?,?,?)



INSERT INTO MEMBER (id, password, name, role) VALUES('6', '2', '3', '4');












