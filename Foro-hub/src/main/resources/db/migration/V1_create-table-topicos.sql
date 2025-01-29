create table topico(

    id bigint not null auto_increment,
    titulo varchar(50) not null,
    mensaje varchar(250) not null,
    fechaDeCracion varchar(10) not null,
    status int not null,
    usuario_id varchar(100) not null,
    curso_id varchar(100) not null,


    primary key(id),
    foreign key(usuario_id) references usuario(id),
    foreign key(curso_id) references curso(id)
);