create table dormitory(
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
    Qpart2_1 int not null,
    Qpart2_2 int not null,
    Qpart2_3 int not null,
    Qpart2_4 int not null,
    Qpart2_5 int not null,
    Qpart2_6 int not null,
    Qpart3_1 int not null,
    Qpart3_2 int not null,
    Qpart3_3 int not null,
    Qpart3_3 int not null,
    Qpart3_4 int not null,
    Qpart3_5 int not null,
    Qpart3_6 int not null,
    Qpart3_7 int not null,
    Qpart3_8 int not null,
    Qpart3_9 int not null,
    Qwant char(12),
    constraint sno_pk foreign key(Sno) references students(Sno),
    constraint Qwant_pk foreign key(Qwant) references students(Sno)
);

create table score(
	Sno char(12) primary key,
    score int
);
create table scoreOrder(
	Onr int primary key,
    Sno char(12),
    constraint scoreNo_pk foreign key(Sno) references students(Sno)
)

