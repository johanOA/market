# MODERADOR (codigo, Email, Nombre, Password)
insert into moderador values (1, "pedrog@gmail.com", "Pedro Gomez","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa");
insert into moderador values (2, "linac@gmail.com", "Lina Caicedo","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa");
insert into moderador values (3, "estebans@gmail.com", "Esteban Sanchez","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa");
insert into moderador values (4, "gabriela@gmail.com", "Gabriela Erazo","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa");
insert into moderador values (5, "diegor@gmail.com", "Diego Rodriguez","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa");

# Usuario (Codigo, Email, Nombre, Password, dirección, Producto_Codigo)
insert into usuario values (1,"juanp@gmail.com","Juan Perez","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa","calle 11 # 16-71");
insert into usuario values (2,"luisg@gmail.com","Luis Gonzales","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa","calle 15 # 75-22");
insert into usuario values (3,"julianah@gmail.com","Juliana Huertas","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa","calle 57 41-30");
insert into usuario values (4,"camilal@gmail.com","Camila Leal","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa","calle 30 20-51");
insert into usuario values (5,"nicolj@gmail.com","Nicol Jimenez","$2a$10$7Y.di/zHO3xnRhWUCKwQhObLuBydSA01fy5q9Iilt/2AP39JaSKXa","calle 50");

# Producto (Codigo, Calificación, Descripción, Estado: 1.Aprobado, 2.Rechazado, 3.Sin revisar, Fecha de creación, Fecha limite, Nombre, Precio, Unidades, Usuario_Codigo)
insert into producto values (101, 3, "telefono con 4 gb de ram", 1, "2023-04-22", "2023-10-22", "Samsumg a12", 560000.0, 2, 1);
insert into producto values (102, 3, "computador asus vivobook 14", 0, "2023-01-15", "2023-06-15", "computador portatil",  2600000.0, 5, 3);
insert into producto values (103, 2, "comedor de seis puestos", 2, "2023-03-13", "2023-09-13", "comedor familiar", 1500000.0, 1, 4);
insert into producto values (104, 1, "camisetas diesel", 2, "2023-02-17", "2023-08-17", "camisetas para hombre", 200000.0, 10, 2);
insert into producto values (105, 5, "estuche para celular", 0, "2023-05-16", "2023-11-16", "forro celulares", 25000.0, 26, 5);


# Comentario (Codigo, Fecha, Mnesaje, Producto_Codigo, Usuario_Codigo)
insert into comentario values(1, "2023-03-13", "El producto es muy bueno", 102,1 );
insert into comentario values(2, "2023-04-16", "necesito uno mas grande", 102,2 );
insert into comentario values(3, "2023-06-20", "quiero en color rosado", 105,2);
insert into comentario values(4, "2023-05-25", "Excelente servicio, llegan muy rapido", 105,3 );

# Compra (Codigo, Fecha de creación, Metodo de pago: 1.TC 2.TD 3.PSE 4.Efectivo, Valor total, Usuario_codigo)
insert into compra values (106, "2023-03-10", 1, 2600000.0, 1);
insert into compra values (107, "2023-07-15", 2, 25000.0, 1);
insert into compra values (108, "2023-05-22", 3, 25000.0, 3);
insert into compra values (109, "2023-04-22", 3, 2600000.0, 4);
insert into compra values (110, "2023-08-16", 4, 50000.0, 2);

# Detalle_Compra (Codigo, Precio Producto, Unidades, compra_codigo, Producto_Codigo)
insert into detalle_compra values (6, 2600000.0, 1, 106, 102);
insert into detalle_compra values (7, 25000.0, 1, 107, 105);
insert into detalle_compra values (8, 25000.0, 1, 108, 105);
insert into detalle_compra values (9, 2600000.0, 1, 109, 102);
insert into detalle_compra values (10, 25000.0, 2, 110, 105);


# Producto_Categorias (Producto_codigo, Categoria: 1.Tecnologia 2.Deporte 3.Hogar 4.Herramientas 5.Automoviles 6.Instrumentos 7.Libros 8.Relojes 9.Salud)
insert into producto_categorias values(101,7);
insert into producto_categorias values(102,1);
insert into producto_categorias values(103,3);
insert into producto_categorias values(104,3);
insert into producto_categorias values(105,1);


# Usuario_telefono (Usuario_codigo, telefono)
insert into usuario_telefono values (1, "3124957856");
insert into usuario_telefono values (1, "7478030");
insert into usuario_telefono values (2, "3116214157");
insert into usuario_telefono values (3, "3225686900");
insert into usuario_telefono values (4, "3136151635");
insert into usuario_telefono values (4, "3126868276");

# Producto_Moderador( codigo, estado: 1.Aprobado 2.Rechazado 3.Sin Revisar, Fecha, Motivo, Moderador_codigo, Producto_Codigo)
insert into producto_moderador values (1, 2, "2023-04-25", "categoria no competente", 1,101 );
insert into producto_moderador values (2, 1, "2023-01-16", "cumple los requisitos", 2,102 );
insert into producto_moderador values (3, 3, "2023-03-15", "falta revisar", 3,103 );
insert into producto_moderador values (4, 3, "2023-02-20", "falta revisar", 4,104 );
insert into producto_moderador values (5, 1, "2023-05-17", "cumple los requisitos", 5,105 );

# Producto_Imagenes (Producto_codigo, URL)
insert into producto_imagenes values (101, "https://www.pricepony.co/blog/wp-content/uploads/2016/12/4GB-RAM-20MP.png");
insert into producto_imagenes values (102, "https://www.ktronix.com/medias/4718017503556-001-750Wx750H?context=bWFzdGVyfGltYWdlc3w5ODY2M3xpbWFnZS9qcGVnfGltYWdlcy9oMGYvaDU1LzkyMTMyNjUwNTE2NzguanBnfGRkYjcxMjIzMjMxMWRhNjVkYTUxYTVjYmM2MTdmNmY1Y2RkNGRjNjY4MzVjYTg3OTZlODJjN2Q4YWNlZjM3NGQ");
insert into producto_imagenes values (103, "https://harvi.com/wp-content/uploads/2021/02/Comedor_Chic.jpg");
insert into producto_imagenes values (104, "https://http2.mlstatic.com/D_NQ_NP_823050-MCO53686978255_022023-W.jpg");
insert into producto_imagenes values (105, "https://tienda-sportfitness.com/wp-content/uploads/2018/07/estuche-para-celular-sportfitness_720x.jpg");