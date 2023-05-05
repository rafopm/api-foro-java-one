ALTER TABLE topicos
    ADD CONSTRAINT unique_titulo_mensaje UNIQUE (titulo); -- especificamos una longitud máxima de 65535 caracteres para la clave única

ALTER TABLE categorias
    ADD CONSTRAINT unique_nombre UNIQUE (nombre);

ALTER TABLE cursos
    ADD CONSTRAINT unique_nombre UNIQUE (nombre);

ALTER TABLE usuarios
    ADD CONSTRAINT unique_correo_electronico UNIQUE (correo_electronico);


