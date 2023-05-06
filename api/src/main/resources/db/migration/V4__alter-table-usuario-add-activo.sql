alter table usuarios add activo tinyint;
update usuarios set activo = 1;