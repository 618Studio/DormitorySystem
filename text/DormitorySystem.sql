/*create table dormitory(
	DroomNr char(10) primary key,
	capacity int not null
);

create table students(
	Sno char(12) primary key,
    Sname char(10) not null,
    Sgender char(2) not null,
	Sgpa float,
    SroomNr char(10),
    constraint SroomNr_pk foreign key(SroomNr) references dormitory(DroomNr)
);

create table question(
	Sno char(12) primary key,
    Qfuture int not null,
    Qpart2_3 char(15) not null,
    Qberth int not null,
    constraint sno_pk foreign key(Sno) references students(Sno)
);

create table score(
	SmainNr char(12) not null,
    SotherNr char (12) not null,
    SameScore int,
    CompareScore int,
    totalScore int,
    constraint main_pk foreign key(SmainNr) references students(Sno),
    constraint other_pk foreign key(SotherNr) references students(Sno)
);


create table matchstudents(
	Mno1 char(12) not null,
    Mno2 char(12) not null,
    type int not null,
    constraint no1_pk foreign key(Mno1) references students(Sno),
    constraint no2_pk foreign key(Mno2) references students(Sno)
)*/

create table standardScore(
	Sno char(12) primary key,
    Score int,
    constraint standard_fk foreign key(Sno) references students(Sno)
)