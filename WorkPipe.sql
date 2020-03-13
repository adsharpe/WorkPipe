--DCL
create user WorkPipe
identified by pass
default tablespace users
temporary tablespace temp
quota 10m on users;

grant connect to WorkPipe;

grant resource to WorkPipe;

grant create session to WorkPipe;

grant create table to Workpipe;

grant create view to WorkPipe;
