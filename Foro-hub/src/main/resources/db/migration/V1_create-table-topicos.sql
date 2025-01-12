create table topico(

    id bigint not null auto_increment,
    titulo varchar(50) not null,
    mensaje varchar(250) not null,
    fechaDeCracion varchar(10) not null,
    status int not null,
    autor varchar(100) not null,
    curso varchar(100) not null,


    primary key(id)

);