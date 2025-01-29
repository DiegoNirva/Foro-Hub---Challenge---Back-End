create table curso(

    id bigint not null auto_increment,
    nombre varchar(50) not null,
    categoria varchar(25) not null,
    topico_id varchar(30),


    primary key(id),
    foreign key (topico_id) references topicos(id)
);