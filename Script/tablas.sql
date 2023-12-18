
DROP table IF EXISTS respuesta_if_saf;
CREATE table respuesta_if_saf(
  fecha timestamp ,
  idorigen integer,
  idgrupo integer,
  idsocio integer,
  respuesta_saf text
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(id integer,username varchar(45),password text,create_at date);
