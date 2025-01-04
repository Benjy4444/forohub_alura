
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    curso varchar(100) not null,
    fechacreacion varchar(6) not null,
    status tinyint,

    primary key(id)

);
