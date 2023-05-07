alter table respuestas add estatus ENUM('ACTIVA','PENDIENTE','EDITADA','RECHAZADA','ELIMINADA') NOT NULL DEFAULT 'ACTIVA';
update respuestas set estatus = 'ACTIVA';

