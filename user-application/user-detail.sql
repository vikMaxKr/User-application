create table user_repository.user
( username varchar(50) not null,
  firstname varchar(50),
  lastname varchar(50),
  email varchar(50),
  primary key(username)
);

insert into user_repository.user(username,firstname,lastname,email)
values("vik101",'vikash','kumar','vik@gmail.com'),
('vik102','Akash','kumar','aka@gmail.com');