-- Insertar datos de ejemplo en la tabla categorias
INSERT INTO categorias (nombre, activo)
VALUES
    ('Programación', 1),
    ('Diseño gráfico', 1),
    ('Marketing digital', 1),
    ('Idiomas', 1);

-- Insertar datos de ejemplo en la tabla cursos
INSERT INTO cursos (nombre, descripcion, activo)
VALUES
    ('Introducción a Python', 'Curso introductorio al lenguaje de programación Python', 1),
    ('Diseño de logotipos', 'Curso práctico de diseño de logotipos', 1),
    ('Marketing en redes sociales', 'Curso sobre estrategias de marketing en redes sociales', 1),
    ('Inglés básico', 'Curso de inglés básico para principiantes', 1);

-- Insertar datos de ejemplo en la tabla usuarios
INSERT INTO usuarios (nombre, email, contrasena, activo)
VALUES
    ('Juan Pérez', 'juan@forotest.com', '$2a$12$2Tc5t8Tx0t6Id14qz9HGy.EoJedZDsJo32b3bOUSvohn5DirxmGe6', 1),
    ('María García', 'maria@forotest.com', '$2a$12$2Tc5t8Tx0t6Id14qz9HGy.EoJedZDsJo32b3bOUSvohn5DirxmGe6', 1),
    ('Pedro Sánchez', 'pedro@forotest.com', '$2a$12$2Tc5t8Tx0t6Id14qz9HGy.EoJedZDsJo32b3bOUSvohn5DirxmGe6', 1),
    ('Gonzalo Ruiz', 'gonza@forotest.com', '$2a$12$2Tc5t8Tx0t6Id14qz9HGy.EoJedZDsJo32b3bOUSvohn5DirxmGe6', 1),
    ('Rafael Pampavilca', 'rafa@forotest.com', '$2a$12$oqgDNQoMBl42v2vYBqAjY.ldxemf/x5CuQvUt7TSELHCDTEg4lbsi', 1);

-- Insertar datos de ejemplo en la tabla topicos
INSERT INTO topicos (titulo, mensaje, estatus, idusuario, idcurso)
VALUES
    ('Problemas con mi código en Python', 'Hola, tengo un error en mi código de Python y necesito ayuda para solucionarlo...', 'ACTIVO', 1, 1),
    ('Mejores prácticas en diseño de logotipos', '¿Cuáles son las mejores prácticas para diseñar un buen logotipo?', 'ACTIVO', 2, 2),
    ('Estrategias de marketing en Facebook', '¿Alguien sabe cuáles son las mejores estrategias para hacer publicidad en Facebook?', 'ACTIVO', 3, 3),
    ('Aprender inglés rápido', '¿Qué métodos recomiendan para aprender inglés rápidamente?', 'ACTIVO', 1, 4),
    ('Ayuda con un problema de programación', 'Tengo un problema con un algoritmo y necesito orientación para resolverlo', 'ACTIVO', 2, 1),
    ('Conceptos básicos de diseño gráfico', 'Me gustaría aprender los conceptos básicos del diseño gráfico', 'ACTIVO', 3, 2),
    ('Estrategias de publicidad en Instagram', '¿Cuáles son las mejores estrategias para promocionar un negocio en Instagram?', 'ACTIVO', 1, 3),
    ('Mejores aplicaciones para aprender idiomas', '¿Cuáles son las mejores aplicaciones para aprender idiomas?', 'ACTIVO', 2, 4),
    ('Error al compilar código C++', 'Recibo un mensaje de error al intentar compilar mi código C++', 'ACTIVO', 3, 1),
    ('Tendencias actuales en diseño web', '¿Cuáles son las tendencias más populares en el diseño web actualmente?', 'ACTIVO', 1, 2),
    ('Cómo aumentar seguidores en Twitter', 'Necesito consejos para aumentar mi número de seguidores en Twitter', 'ACTIVO', 2, 3),
    ('Mejores recursos para aprender francés', '¿Dónde puedo encontrar buenos recursos para aprender francés?', 'ACTIVO', 3, 4),
    ('Problema con un bucle en Java', 'Mi bucle en Java no se está ejecutando correctamente, necesito ayuda', 'ACTIVO', 1, 1),
    ('Diseño de interfaces de usuario', '¿Cuáles son los principios clave para diseñar interfaces de usuario efectivas?', 'ACTIVO', 2, 2),
    ('Estrategias de email marketing', '¿Cuáles son las mejores estrategias para llevar a cabo una campaña de email marketing?', 'ACTIVO', 3, 3),
    ('Consejos para aprender japonés', 'Estoy interesado en aprender japonés y me gustaría recibir algunos consejos útiles', 'ACTIVO', 1, 4),
    ('Error al conectar a una base de datos', 'Recibo un error al intentar establecer una conexión con una base de datos MySQL', 'ACTIVO', 2, 1),
    ('Mejores prácticas en diseño de interfaces móviles', '¿Cuáles son las mejores prácticas para diseñar interfaces de usuario móviles?', 'ACTIVO', 3, 2),
    ('Estrategias de marketing en LinkedIn', '¿Cómo puedo utilizar LinkedIn para promocionar mi negocio de manera efectiva?', 'ACTIVO', 1, 3),
    ('Mejores técnicas para memorizar vocabulario en inglés', 'Necesito ayuda para memorizar vocabulario en inglés de manera más eficiente', 'ACTIVO', 2, 4);

-- Insertar datos de ejemplo en la tabla respuestas
INSERT INTO respuestas (mensaje, estatus, idusuario, idtopico)
VALUES
    ('Puedes compartir tu código para que podamos ayudarte mejor?', 'ACTIVA', 2, 1),
    ('Lo más importante es que el logotipo sea fácil de reconocer y recordar', 'ACTIVA', 3, 2),
    ('Te recomiendo hacer publicidad en grupos de Facebook relacionados con tu producto o servicio', 'ACTIVA', 1, 3),
    ('Lo mejor es practicar todos los días y usar aplicaciones como Duolingo', 'ACTIVA', 2, 4),
    ('Aquí tienes un ejemplo de cómo resolver ese problema:', 'ACTIVA', 1, 5),
    ('Los principios de diseño como la alineación y la jerarquía son fundamentales', 'ACTIVA', 2, 6),
    ('Utiliza anuncios pagados para llegar a un público más amplio en Instagram', 'ACTIVA', 3, 7),
    ('Recomiendo utilizar aplicaciones como Duolingo y Memrise para aprender idiomas', 'ACTIVA', 1, 8),
    ('Verifica que estés utilizando la sintaxis correcta y que hayas incluido todas las bibliotecas necesarias', 'ACTIVA', 2, 9),
    ('El diseño minimalista y el uso de colores llamativos son tendencias populares en el diseño web', 'ACTIVA', 3, 10),
    ('Publica contenido relevante y utiliza hashtags relacionados para aumentar tu visibilidad en Twitter', 'ACTIVA', 1, 11),
    ('Puedes encontrar recursos para aprender francés en sitios web como Duolingo y Babbel', 'ACTIVA', 2, 12),
    ('Asegúrate de que el bucle esté correctamente estructurado y que se cumplan las condiciones de salida', 'ACTIVA', 3, 13),
    ('La simplicidad y la consistencia son clave para el diseño de interfaces de usuario efectivas', 'ACTIVA', 1, 14),
    ('Personaliza tus emails y segmenta tu lista de destinatarios para obtener mejores resultados', 'ACTIVA', 2, 15),
    ('Practica regularmente y utiliza aplicaciones como Anki para memorizar vocabulario', 'ACTIVA', 3, 16),
    ('Verifica la configuración de tu conexión y asegúrate de tener los datos de acceso correctos', 'ACTIVA', 1, 17),
    ('Considera el tamaño de pantalla y la usabilidad con una sola mano al diseñar interfaces móviles', 'ACTIVA', 2, 18),
    ('Crea una estrategia de contenido relevante y participa en grupos relevantes de LinkedIn', 'ACTIVA', 3, 19),
    ('Utiliza técnicas mnemotécnicas como asociaciones visuales para memorizar vocabulario en inglés', 'ACTIVA', 1, 20);

-- Insertar datos de ejemplo en la tabla topicoscategorias
INSERT INTO topicoscategorias (idtopico, idcategoria)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 1),
    (6, 2),
    (7, 3),
    (8, 4),
    (9, 1),
    (10, 2),
    (11, 3),
    (12, 4),
    (13, 1),
    (14, 2),
    (15, 3),
    (16, 4),
    (17, 1),
    (18, 2),
    (19, 3),
    (20, 4);
