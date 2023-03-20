INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Franco', 'Pappatella', 'pappatella.francoariel@gmail.com', '2022-12-1','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Perez', 'juanperez@gmail.com', '2022-12-7','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Agustina', 'Gimenez', 'gimenezagustina@gmail.com', '2022-12-9','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Gloria', 'Ramirez', 'gloria_ramirez@hotmail.com', '2022-12-15','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Ariel', 'Rodriguez', 'ari_rodriguez@hotmail.com', '2022-12-20','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Pepe', 'Biondi', 'biondpepe@hotmail.com', '2022-1-1','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Marta', 'Sanchez', 'mart_sanchez@gmail.com', '2022-1-5','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Enrique', 'Palazzo', 'enrique_palazzo@hotmail.com', '2022-2-8','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Paula', 'Gomez', 'pgomez@hotmail.com', '2022-2-10','');

/* */
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Franco', 'Pappatella', 'pappatella.francoariel@gmail.com', '2022-12-1','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Perez', 'juanperez@gmail.com', '2022-12-7','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Agustina', 'Gimenez', 'gimenezagustina@gmail.com', '2022-12-9','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Gloria', 'Ramirez', 'gloria_ramirez@hotmail.com', '2022-12-15','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Ariel', 'Rodriguez', 'ari_rodriguez@hotmail.com', '2022-12-20','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Pepe', 'Biondi', 'biondpepe@hotmail.com', '2022-1-1','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Marta', 'Sanchez', 'mart_sanchez@gmail.com', '2022-1-5','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Enrique', 'Palazzo', 'enrique_palazzo@hotmail.com', '2022-2-8','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Paula', 'Gomez', 'pgomez@hotmail.com', '2022-2-10','');
/* */

/* */
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Franco', 'Pappatella', 'pappatella.francoariel@gmail.com', '2022-12-1','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Perez', 'juanperez@gmail.com', '2022-12-7','');
/* */

/* */
INSERT INTO productos (nombre, precio, create_at) VALUES ('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('CPU Intel i5 10400F', 200000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Apple Ipod Suffle', 828200, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Notebook Sony Z110', 390000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Impresora HP F2280', 69280, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Celular Samsung S23 Ultra', 153110, NOW());
/* */

/* */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura de artículos de oficina', '', 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3, 1, 6);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (4, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3, 1, 6);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 5);
/* */



