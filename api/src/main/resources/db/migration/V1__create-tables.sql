CREATE TABLE categorias (
                            `idcategoria` INT NOT NULL AUTO_INCREMENT,
                            `nombre` VARCHAR(255) NOT NULL,
                            PRIMARY KEY (`idcategoria`)
);

CREATE TABLE cursos (
                        `idcurso` INT NOT NULL AUTO_INCREMENT,
                        `nombre` VARCHAR(255) NOT NULL,
                        `descripcion` TEXT NULL DEFAULT NULL,
                        PRIMARY KEY (`idcurso`)
);

CREATE TABLE usuarios (
                          `idusuario` INT NOT NULL AUTO_INCREMENT,
                          `nombre` VARCHAR(255) NOT NULL,
                          `email` VARCHAR(255) NOT NULL,
                          `contrasena` VARCHAR(255) NOT NULL,
                          PRIMARY KEY (`idusuario`)
);

CREATE TABLE topicos (
                         `idtopico` INT NOT NULL AUTO_INCREMENT,
                         `titulo` VARCHAR(255) NOT NULL,
                         `mensaje` TEXT NOT NULL,
                         `fechacreacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `estatus` ENUM('ACTIVO', 'CERRADO', 'ELIMINADO') NOT NULL DEFAULT 'ACTIVO',
                         `idusuario` INT NOT NULL,
                         `idcurso` INT NOT NULL,
                         PRIMARY KEY (`idtopico`),
                         INDEX `idusuario` (`idusuario`),
                         INDEX `idcurso` (`idcurso`),
                         CONSTRAINT `topicos_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`),
                         CONSTRAINT `topicos_ibfk_2` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`)
);

CREATE TABLE respuestas (
                            `idrespuesta` INT NOT NULL AUTO_INCREMENT,
                            `mensaje` TEXT NOT NULL,
                            `fechacreacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            `idusuario` INT NOT NULL,
                            `idtopico` INT NOT NULL,
                            PRIMARY KEY (`idrespuesta`),
                            INDEX `idusuario` (`idusuario`),
                            INDEX `idtopico` (`idtopico`),
                            CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`),
                            CONSTRAINT `respuestas_ibfk_2` FOREIGN KEY (`idtopico`) REFERENCES `topicos` (`idtopico`)
);

CREATE TABLE topicoscategorias (
                                    `idtopicocategoria` INT NOT NULL AUTO_INCREMENT,
                                    `idtopico` INT NOT NULL,
                                    `idcategoria` INT NOT NULL,
                                    PRIMARY KEY (`idtopicocategoria`),
                                    INDEX `idcategoria` (`idcategoria`),
                                    CONSTRAINT `topicoscategorias_ibfk_1` FOREIGN KEY (`idtopico`) REFERENCES `topicos` (`idtopico`),
                                    CONSTRAINT `topicoscategorias_ibfk_2` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idcategoria`)
);