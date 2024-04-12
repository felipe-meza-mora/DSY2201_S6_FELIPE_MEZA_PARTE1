CREATE TABLE usuarios (
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1)NOT NULL,
nombre VARCHAR2(100) NOT NULL,
usuario VARCHAR2(100) NOT NULL,
password VARCHAR2(100) NOT NULL,
direccion VARCHAR2(100) NOT NULL
);
ALTER TABLE usuarios ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

INSERT INTO Usuarios (nombre, usuario, password,direccion) VALUES ('Felipe Meza Mora', 'fmeza', 'Qwerty_1','Alcalde Pedro Alarcón 887 depto 1210, San Miguel');
INSERT INTO Usuarios (nombre, usuario, password,direccion) VALUES ('Elizabeth Maldonado', 'emaldonado', 'Qwerty_1','Pasaje San Gabriel 11443, La Florida');
INSERT INTO Usuarios (nombre, usuario, password,direccion) VALUES ('María', 'maria89', 'Asd_123','Pasaje Laura 687, Conchali');


CREATE TABLE Pedidos(
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1)NOT NULL,
descripcion VARCHAR2(100) NOT NULL,
valor int NOT NULL,
usuario int NOT NULL
);


ALTER TABLE pedidos ADD CONSTRAINT usuario_pedido FOREIGN KEY(usuario) REFERENCES usuarios (id);



INSERT INTO Pedidos (descripcion, valor, usuario) VALUES ('Pedido 1', 50000, 1);
INSERT INTO Pedidos (descripcion, valor, usuario) VALUES ('Pedido 2', 70000, 1);
INSERT INTO Pedidos (descripcion, valor, usuario) VALUES ('Pedido 3', 100000, 1);


INSERT INTO Pedidos (descripcion, valor, usuario) VALUES ('Pedido 1',3000, 2);

INSERT INTO Pedidos (descripcion, valor, usuario) VALUES ('Pedido 1', 50000, 3);
INSERT INTO Pedidos (descripcion, valor, usuario) VALUES ('Pedido 2', 70000, 3);
INSERT INTO Pedidos (descripcion, valor, usuario) VALUES ('Pedido 3', 100000, 3);



COMMIT;



