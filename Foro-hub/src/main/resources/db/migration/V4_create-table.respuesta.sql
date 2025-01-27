create table respuesta(

    id bigint not null auto_increment,
    mensaje varchar(250) not null unique,
    topico bigint not null,
    fechaDeCreacion varchar(30) not null,
    autor bigint not null,


    primary key(id),
    foreign key(topico_id) references topico(id),
    foreign key(usuario_id) references usuario(id)
);