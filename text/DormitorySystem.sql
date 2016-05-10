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
);*/

create table question(
	Sno char(12) primary key,
    Qfuture int not null,
    Qpart2_3 char(15) not null,
    Qberth int not null,
    constraint sno_pk foreign key(Sno) references students(Sno)
);

/*create table score(
	Sno char(12) primary key,
    score int(16)
);
create table scoreOrder(
	Onr int primary key,
    Sno char(12),
    constraint scoreNo_pk foreign key(Sno) references students(Sno)
)
*/