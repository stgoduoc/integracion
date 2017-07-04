CREATE TABLE categoria(
  id int not null primary key
  , categoria varchar(50)
);

CREATE TABLE producto(
  id int not null primary key
  , producto varchar2(50) not null
  , precio number not null
  , descripcion varchar2(255) 
  , categoria_id int not null
);

ALTER TABLE producto ADD
  FOREIGN KEY(categoria_id)
    REFERENCES categoria(id)
;

SELECT * FROM producto;

SELECT * FROM categoria;
