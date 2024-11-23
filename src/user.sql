use practice;
create table user(id int primary key auto_increment, user_id varchar(30) unique not null, user_pwd varchar(30) not null);
select * from user;

select * from user where user_id = '김진홍' and user_pwd = '4578';

