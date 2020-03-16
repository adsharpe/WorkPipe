
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

-- Insertions
--Insert into login(id,username, password)
--values (1, 'Jon', 'pass');
--
--Insert into Employee(id,firstname, lastname, login_id, supervisor_id)
--values (1,'Jonathan', 'Mendez', 1, 1);
--commit;