CREATE TABLE cliente(
  id int not null primary key
  , nombre varchar(255) not null
  , telefono_movil varchar(20) not null
  , edad int not null
);

CREATE TABLE direccion(
  id int not null primary key
  , direccion varchar(255) not null
  , comuna varchar(255) 
);

CREATE TABLE cliente_direcciones(
  cliente_id int not null
  , direccion_id int not null
);

ALTER TABLE cliente_direcciones ADD
  FOREIGN KEY(cliente_id)
    REFERENCES cliente(id)
;
ALTER TABLE cliente_direcciones ADD
  FOREIGN KEY(direccion_id)
    REFERENCES direccion(id)
;

CREATE SEQUENCE direccion_seq
  START WITH     1
  INCREMENT BY   1
;

SELECT * FROM cliente;
SELECT * FROM DIRECCION;
SELECT * FROM CLIENTE_DIRECCIONES;




