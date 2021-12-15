
create table table_proveedor(idPro varchar(13) not null, nombre varchar(50) not null, telefono bigint(10),
direccion tinytext, correo varchar(50), primary key(idPro));


create table  table_categorias(idCat int not null, nombre varchar(45) not null, primary key(idCat));

create table table_producto(codigo varchar(25) not null,  marca varchar(50) not null,
descripcion tinytext not null, precio float not null, stock int not null, idPro varchar(13) not null,
idCat int not null,
primary key(codigo), FOREIGN KEY (idPro) REFERENCES table_proveedor (idPro),
FOREIGN KEY (idCat) REFERENCES table_categorias (idCat));

codigo,  marca, descripcion, precio, stock, idPro, idCat

CREATE TABLE table_Personal(
  idPer int(11) NOT NULL,
  Nombre varchar(45) NOT NULL,
  Edad bigint NOT NULL,
  Sexo varchar(20) NOT NULL,
  Telefono bigint NOT NULL,
  Direccion varchar(100) NOT NULL,
  Correo varchar(50) NOT NULL,
  Tipo varchar(30) NOT NULL,
  Usuario varchar(30) NOT NULL,
  Contrasena varchar(15) NOT NULL,
  PRIMARY KEY (idPer)
);



create table  table_venta(folio int not null, total float not null, fecha date not null, hora datetime not null,
codigo varchar(25) not null, primary key(folio),
FOREIGN KEY (codigo) REFERENCES table_producto (codigo));

CREATE TABLE table_facturas (
  No_Facturas int(11) NOT NULL,
  fecha date NOT NULL,
  totals int(11) NOT NULL,

);
