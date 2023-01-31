create table guestbook(
seq   number primary key, -- sequence객체로부터 값을 얻어온다.
name  varchar2(30),
email  varchar2(30),
homepage  varchar2(35),
subject  varchar2(500) not null,
content  varchar2(4000) not null,
logtime  date);


--오라클의 hidden column을 rownum이라고 한다.

select * from
(select rownum rn, tt.*from
 (select seq, name, email,homepage, subject, content, to_char(logtime,'YY-MM-DD') AS logtime 
 from guestbook order by seq desc) tt)
 where rn>=1 and rn<=3;
-- 가상테이블처럼 처리한 것이다.