CREATE TABLE categorias (
                            `id_categoria` INT NOT NULL AUTO_INCREMENT,
                            `nombre` VARCHAR(255) NOT NULL,
                            PRIMARY KEY (`id_categoria`)
);

CREATE TABLE cursos (
                        `id_curso` INT NOT NULL AUTO_INCREMENT,
                        `nombre` VARCHAR(255) NOT NULL,
                        `descripcion` TEXT NULL DEFAULT NULL,
                        PRIMARY KEY (`id_curso`)
);

CREATE TABLE usuarios (
                          `id_usuario` INT NOT NULL AUTO_INCREMENT,
                          `nombre` VARCHAR(255) NOT NULL,
                          `correo_electronico` VARCHAR(255) NOT NULL,
                          `contrasena` VARCHAR(255) NOT NULL,
                          PRIMARY KEY (`id_usuario`)
);

CREATE TABLE topicos (
                         `id_topico` INT NOT NULL AUTO_INCREMENT,
                         `titulo` VARCHAR(255) NOT NULL,
                         `mensaje` TEXT NOT NULL,
                         `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `estatus` ENUM('ACTIVO', 'CERRADO', 'ELIMINADO') NOT NULL DEFAULT 'ACTIVO',
                         `id_usuario` INT NOT NULL,
                         `id_curso` INT NOT NULL,
                         PRIMARY KEY (`id_topico`),
                         INDEX `id_usuario` (`id_usuario`),
                         INDEX `id_curso` (`id_curso`),
                         CONSTRAINT `topicos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
                         CONSTRAINT `topicos_ibfk_2` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
);

CREATE TABLE respuestas (
                            `id_respuesta` INT NOT NULL AUTO_INCREMENT,
                            `mensaje` TEXT NOT NULL,
                            `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            `id_usuario` INT NOT NULL,
                            `id_topico` INT NOT NULL,
                            PRIMARY KEY (`id_respuesta`),
                            INDEX `id_usuario` (`id_usuario`),
                            INDEX `id_topico` (`id_topico`),
                            CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
                            CONSTRAINT `respuestas_ibfk_2` FOREIGN KEY (`id_topico`) REFERENCES `topicos` (`id_topico`)
);

CREATE TABLE topicos_categorias (
                                    `id_topico_categoria` INT NOT NULL AUTO_INCREMENT,
                                    `id_topico` INT NOT NULL,
                                    `id_categoria` INT NOT NULL,
                                    PRIMARY KEY (`id_topico_categoria`),
                                    INDEX `id_categoria` (`id_categoria`),
                                    CONSTRAINT `topicos_categorias_ibfk_1` FOREIGN KEY (`id_topico`) REFERENCES `topicos` (`id_topico`),
                                    CONSTRAINT `topicos_categorias_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
);