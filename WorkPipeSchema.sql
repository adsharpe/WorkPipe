
--drop tables

DROP table login cascade constraints;
DROP table employee cascade constraints;
DROP table projects cascade constraints;
DROP table status cascade constraints;
DROP table task cascade constraints;
DROP table tasks_comment cascade constraints;
DROP table projects_comment cascade constraints;
DROP table alert cascade constraints;

--create tables

CREATE table login (
    id number (20) primary key,
    username varchar2 (25) not null,
    pass varchar2 (25) not null
);

CREATE table employee (
    id number (20) primary key,
    first_name varchar2 (25) not null,
    last_name varchar2 (25) not null,
    login_id number (20) not null,
        constraint fk_employee_login foreign key (login_id) references login(id),
    title varchar2 (20) not null,
    supervisor number (20) not null,
        constraint fk_employee_employee foreign key (supervisor) references employee(id)
);

CREATE table projects (
    id number (20) primary key,
    project_name varchar2 (56) not null,
    employee_tally number (20) not null,
    team_lead_id number (20),
        constraint fk_project_employee foreign key (team_lead_id) references employee (id),
    start_date date,
    end_date date,
    task_tally number (20)
);

CREATE table status (
    id number (20) primary key,
    status_level varchar2 (25) not null
);

CREATE table tasks (
    id number (20) primary key,
    assigned_employee number (20) not null,
        constraint fk_tasks_employee foreign key (assigned_employee) references employee (id),
    status_id number (20) not null,
        constraint fk_task_employee foreign key (status_id) references status (id)
);

CREATE table tasks_comment (
    --Richard said try to stay away from composite keys in Hibernate
    id number (20) primary key,
    task_id number (20) not null,
        constraint fk_taskscomment_tasks foreign key (task_id) references tasks (id),
    employee_id number (20) not null,
        constraint fk_taskscomment_employee foreign key (employee_id) references employee (id), 
    comments varchar2 (250) not null
);

CREATE table projects_comment (
    id number (20) primary key,
    proejct_id number (20) not null,
        constraint fk_projectcomment_projects foreign key (project_id) references projects (id),
    employee_id number (20) not null,
        constraint fk_projectcomment_employee foreign key (employee_id) references employee (id),
        comments varchar2 (250) not null
);

CREATE table alert (
    id number (20) primary key,
    sender_id number (20) not null,
        constraint fk_alert_employee foreign key (sender_id) references employee (id),
    receiver_id number (20) not null,
        constraint fk_alert_employee2 foreign key (receiver_id) references employee (id),
    time_stamp date,
    message varchar2 (250) not null
);

--sequences

CREATE sequence login_seq nocache;
CREATE sequence employee_seq nocache;
CREATE sequence projects_seq nocache;
CREATE sequence tasks_seq nocache;
CREATE sequence status_seq nocache;
CREATE sequence alert_seq nocache;
CREATE sequence projects_comment_seq nocache;
CREATE sequence tasks_comment_seq nocache;

-- Initilization Login
Insert into login(id,username, password)
values (1, 'Jon', 'pass');
Insert into login(id,username, password)
values (2, 'Cov', 'pass');
Insert into login(id,username, password)
values (3, 'Apollo', 'pass');
Insert into login(id,username, password)
values (4, 'Stephen', 'pass');
Insert into login(id,username, password)
values (5, 'Richard', 'pass');

-- Initilization Employee
Insert into Employee(id,firstname, lastname, login_id, supervisor_id)
values (1,'Jonathan', 'Mendez', 1, 5);
Insert into Employee(id,firstname, lastname, login_id, title,supervisor_id)
values (2,'Covals', 'Douze', 2, 'Team Lead',5);
Insert into Employee(id,firstname, lastname, login_id, supervisor_id)
values (3,'Apollo', 'D. Sharpe', 3, 5);
Insert into Employee(id,firstname, lastname, login_id, supervisor_id)
values (4,'Stephen', 'Wingbermuehle', 4, 5);
Insert into Employee(id,firstname, lastname, login_id, title,supervisor_id)
values (5,'Richard', 'Orr', 5, 'Supervisor',5);

-- Initilization Project
Insert into Project(id, projectname, teamlead_id, startdate)
values (1, 'WorkPipe', 2, TO_Date('09/03/2020', 'DD/MM/YYYY'));

-- Initilization Project_Employee
Insert into Project_Employee(id, Employee_ID, Project_ID)
values(1,1,1);
Insert into Project_Employee(id, Employee_ID, Project_ID)
values(2,2,1);
Insert into Project_Employee(id, Employee_ID, Project_ID)
values(3,3,1);
Insert into Project_Employee(id, Employee_ID, Project_ID)
values(4,4,1);

--Initilization Status
Insert into Status(id, statusname)
values(1, 'Not Assigned');
Insert into Status(id, statusname)
values(2, 'In progress');
Insert into Status(id, statusname)
values(3, 'Waiting Approval');
Insert into Status(id, statusname)
values(4, 'Completed');
Insert into Status(id, statusname)
values(5, 'Rejected');

-- Initilizatoin Task
Insert into Task(id, description_id, employee_id, status_id, project_id)
values(1, 1, 1, 2, 1);
Insert into Task(id, description_id, employee_id, status_id, project_id)
values(2, 2, 2, 2, 1);
Insert into Task(id, description_id, employee_id, status_id, project_id)
values(3, 3, 3, 2, 1);
Insert into Task(id, description_id, employee_id, status_id, project_id)
values(4, 4, 4, 2, 1);
Insert into Task(id, description_id, employee_id, status_id, project_id)
values(5, 5, 2, 2, 1);
Insert into Task(id, description_id,  status_id, project_id)
values(6, 6, 1, 1);
Insert into Task(id, description_id,  status_id, project_id)
values(7, 7, 1, 1);


-- Initilization Text
    --Task Description
Insert into Text(id, string)
values(1, 'Create a login component');
Insert into Text(id, string)
values(2, 'Create a task component');
Insert into Text(id, string)
values(3, 'Create a project component');
Insert into Text(id, string)
values(4, 'Create the entire back-end');
Insert into Text(id, string)
values (5, 'Add CSS/Bootstrap');
Insert into Text(id, string)
values (6, 'Add more componenet');
Insert into Text(id, string)
values (7, 'Do nothing');
    --Project Comment
Insert into Text(id, string)
values (8, 'Is there any more task we might have?');
Insert into Text(id, string)
values (9, 'Not that I can think of.');
    --Task Comment
Insert into Text(id, string)
values (10, 'How is the component coming along?');
Insert into Text(id, string)
values (11, 'Almost done!');

-- Initilization Project_Comment
Insert into Project_Comment(id, project_id, employee_id, text_id)
values(1, 1, 2, 8);
Insert into Project_Comment(id, project_id, employee_id, text_id)
values(2, 1, 1, 9);

-- Initilization Task_Comment
Insert into Task_Comment(id, task_id, employee_id, text_id)
values(1, 3, 2, 10);
Insert into Task_Comment(id, task_id, employee_id, text_id)
values(2, 3, 3, 11);


Delete From Project Where
projectname = 'test3';
Delete From Project Where
id = 8;
Delete From Project Where
id = 12;
Delete From Project Where
id = 13;
commit;