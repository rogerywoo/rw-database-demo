-- Need to comment out table creation.
-- It is initialized by schema update of hibernate
-- which is triggered by SpringBoot Autoconfiguration.

--create table person
--(
--    id integer not null,
--    name varchar(255) not null,
--    location varchar(255),
--    birth_date timestamp,
--    primary key(id)
--);

--insert into person (id, name, location, birth_date)
--values (10001, 'roger', 'burke', sysdate());
--insert into person (id, name, location, birth_date)
--values (10002, 'james', 'los angles', sysdate());
--insert into person (id, name, location, birth_date)
--values (10003, 'peter', 'new york', sysdate());

insert into course (id, name, created_date, last_updated_date) values (10001, 'JPA in 50 steps', sysdate(), sysdate());
insert into course (id, name, created_date, last_updated_date) values (10002, 'JPA in 500 steps', sysdate(), sysdate());
insert into course (id, name, created_date, last_updated_date) values (10003, 'JPA in 5000 steps', sysdate(), sysdate());

--insert into course_detail (id, name) values (10001, 'JPA in 50 steps');
--insert into course_detail (id, name) values (10002, 'JPA in 500 steps');
--insert into course_detail (id, name) values (10003, 'JPA in 5000 steps');

--
insert into passport (id, number, created_date, last_updated_date) values (40001, 'A1234', sysdate(), sysdate());
insert into passport (id, number, created_date, last_updated_date) values (40002, 'B1234', sysdate(), sysdate());
insert into passport (id, number, created_date, last_updated_date) values (40003, 'C1234', sysdate(), sysdate());

insert into student (id, name, passport_id, created_date, last_updated_date) values (20001, 'Bill', 40001, sysdate(), sysdate());
insert into student (id, name, passport_id, created_date, last_updated_date) values (20002, 'James', 40003, sysdate(), sysdate());
insert into student (id, name, passport_id, created_date, last_updated_date) values (20003, 'Kevin', 40002, sysdate(), sysdate());



insert into review (id, rating, description, course_id, created_date, last_updated_date) values (50001, 1, 'Very bad', 10001, sysdate(), sysdate());
insert into review (id, rating, description, course_id, created_date, last_updated_date) values (50002, 5, 'Very good', 10001, sysdate(), sysdate());
insert into review (id, rating, description, course_id, created_date, last_updated_date) values (50003, 4, null, 10002, sysdate(), sysdate());
insert into review (id, rating, description, course_id, created_date, last_updated_date) values (50004, 2, null, 10002, sysdate(), sysdate());
insert into review (id, rating, description, course_id, created_date, last_updated_date) values (50005, 3, null, 10003, sysdate(), sysdate());


insert into student_course (student_id, course_id) values (20001, 10001);
insert into student_course (student_id, course_id) values (20001, 10002);
insert into student_course (student_id, course_id) values (20002, 10001);
insert into student_course (student_id, course_id) values (20003, 10001);
insert into student_course (student_id, course_id) values (20003, 10002);

