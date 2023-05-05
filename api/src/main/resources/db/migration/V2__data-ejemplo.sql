INSERT INTO categorias (nombre)
VALUES
    ('Programación'),
    ('Diseño gráfico'),
    ('Marketing digital'),
    ('Idiomas');

INSERT INTO cursos (nombre, descripcion)
VALUES
    ('Introducción a Python', 'Curso introductorio al lenguaje de programación Python'),
    ('Diseño de logotipos', 'Curso práctico de diseño de logotipos'),
    ('Marketing en redes sociales', 'Curso sobre estrategias de marketing en redes sociales'),
    ('Inglés básico', 'Curso de inglés básico para principiantes');

INSERT INTO usuarios (nombre, correo_electronico, contrasena)
VALUES
    ('Juan Pérez', 'juan.perez@example.com', 'contraseña123'),
    ('María García', 'maria.garcia@example.com', 'contraseña456'),
    ('Pedro Sánchez', 'pedro.sanchez@example.com', 'contraseña789');

INSERT INTO topicos (titulo, mensaje, estatus, id_usuario, id_curso)
VALUES
    ('Problemas con mi código en Python', 'Hola, tengo un error en mi código de Python y necesito ayuda para solucionarlo...', 'activo', 1, 1),
    ('Mejores prácticas en diseño de logotipos', '¿Cuáles son las mejores prácticas para diseñar un buen logotipo?', 'activo', 2, 2),
    ('Estrategias de marketing en Facebook', '¿Alguien sabe cuáles son las mejores estrategias para hacer publicidad en Facebook?', 'activo', 3, 3),
    ('Aprender inglés rápido', '¿Qué métodos recomiendan para aprender inglés rápidamente?', 'activo', 1, 4);

INSERT INTO respuestas (mensaje, id_usuario, id_topico)
VALUES
    ('Puedes compartir tu código para que podamos ayudarte mejor?', 2, 1),
    ('Lo más importante es que el logotipo sea fácil de reconocer y recordar', 3, 2),
    ('Te recomiendo hacer publicidad en grupos de Facebook relacionados con tu producto o servicio', 1, 3),
    ('Lo mejor es practicar todos los días y usar aplicaciones como Duolingo', 2, 4);

INSERT INTO topicos_categorias (id_topico, id_categoria)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);
