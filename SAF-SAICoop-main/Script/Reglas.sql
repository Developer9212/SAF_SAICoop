

DELETE FROM tablas WHERE idtabla='saf' AND idelemento='empresa';
INSERT INTO tablas(idtabla,idelemento,nombre,dato1)VALUES('saf','empresa','Codigo de empresa','001');


DELETE FROM tablas WHERE idtabla='saf' AND idelemento='datos_token';
INSERT INTO tablas(idtabla,idelemento,nombre,dato1,dato2)VALUES('saf','datos_token','Datos para obtenrer token','Capital2020','conexion@capitalactivo.com.mx');
