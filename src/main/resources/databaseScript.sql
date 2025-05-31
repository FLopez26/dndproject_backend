SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS `dnddatabase`;
USE `dnddatabase`;

-- Table `stats_change`
CREATE TABLE IF NOT EXISTS `stats_change` (
  `stats_change_id` INT NOT NULL,
  `strength` INT,
  `dexterity` INT,
  `constitution` INT,
  `intelligence` INT,
  `wisdom` INT,
  `charisma` INT,
  `hit_points` INT,
  PRIMARY KEY (`stats_change_id`)
);

-- Table `stats`
CREATE TABLE IF NOT EXISTS `stats` (
  `stats_id` INT NOT NULL AUTO_INCREMENT,
  `strength` INT,
  `dexterity` INT,
  `constitution` INT,
  `intelligence` INT,
  `wisdom` INT,
  `charisma` INT,
  `hit_points` INT,
  PRIMARY KEY (`stats_id`)
);

-- Table `race`
CREATE TABLE IF NOT EXISTS `race` (
  `race_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `race_selection` INT,
  `speed` INT,
  `abilities` TEXT,
  `competencies` TEXT,
  `stats_change_id` INT,
  PRIMARY KEY (`race_id`),
  INDEX `fk_Race_StatsChange_idx` (`stats_change_id` ASC),
  CONSTRAINT `fk_Race_StatsChange1`
    FOREIGN KEY (`stats_change_id`)
    REFERENCES `stats_change` (`stats_change_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table `character_class`
CREATE TABLE IF NOT EXISTS `character_class` (
  `class_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `class_selection` INT,
  `dice_hit_points` VARCHAR(255),
  `equipment` TEXT,
  `competencies` TEXT,
  `abilities` TEXT,
  PRIMARY KEY (`class_id`)
);

-- Table `background`
CREATE TABLE IF NOT EXISTS `background` (
  `background_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `equipment` TEXT,
  `competencies` TEXT,
  PRIMARY KEY (`background_id`)
);

-- Table `abilities`
CREATE TABLE IF NOT EXISTS `abilities` (
  `ability_id` INT NOT NULL AUTO_INCREMENT,
  `race_id` INT,
  `class_id` INT,
  PRIMARY KEY (`ability_id`),
  INDEX `fk_Abilities_Race_idx` (`race_id` ASC),
  INDEX `fk_Abilities_CharacterClass_idx` (`class_id` ASC),
  CONSTRAINT `fk_Abilities_Race1`
    FOREIGN KEY (`race_id`)
    REFERENCES `race` (`race_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Abilities_CharacterClass1`
    FOREIGN KEY (`class_id`)
    REFERENCES `character_class` (`class_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table `equipment`
CREATE TABLE IF NOT EXISTS `equipment` (
  `equipment_id` INT NOT NULL AUTO_INCREMENT,
  `class_id` INT,
  `background_id` INT,
  PRIMARY KEY (`equipment_id`),
  INDEX `fk_Equipment_CharacterClass_idx` (`class_id` ASC), 
  INDEX `fk_Equipment_Background_idx` (`background_id` ASC),
  CONSTRAINT `fk_Equipment_CharacterClass1`
    FOREIGN KEY (`class_id`)
    REFERENCES `character_class` (`class_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipment_Background1`
    FOREIGN KEY (`background_id`)
    REFERENCES `background` (`background_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table `competencies`
CREATE TABLE IF NOT EXISTS `competencies` (
  `competency_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `class_id` INT,
  `background_id` INT,
  PRIMARY KEY (`competency_id`),
  INDEX `fk_Competencies_CharacterClass_idx` (`class_id` ASC),
  INDEX `fk_Competencies_Background_idx` (`background_id` ASC),
  CONSTRAINT `fk_Competencies_CharacterClass1`
    FOREIGN KEY (`class_id`)
    REFERENCES `character_class` (`class_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Competencies_Background1`
    FOREIGN KEY (`background_id`)
    REFERENCES `background` (`background_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table `characters`
CREATE TABLE IF NOT EXISTS `characters` (
  `character_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `description` TEXT,
  `personality_traits` VARCHAR(255),
  `ideals` VARCHAR(255),
  `bonds` VARCHAR(255),
  `flaws` VARCHAR(255),
  `image` BLOB,
  `is_public` BOOL,
  `stats_id` INT,
  `race_id` INT,
  `class_id` INT,
  `background_id` INT,
  `abilities_id` INT,
  `equipment_id` INT,
  `competencies_id` INT,
  `user_id` INT,
  PRIMARY KEY (`character_id`),
  INDEX `fk_Characters_Stats_idx` (`stats_id` ASC),
  INDEX `fk_Characters_Race_idx` (`race_id` ASC),
  INDEX `fk_Characters_CharacterClass_idx` (`class_id` ASC), 
  INDEX `fk_Characters_Background_idx` (`background_id` ASC),
  INDEX `fk_Characters_Abilities_idx` (`abilities_id` ASC),
  INDEX `fk_Characters_Equipment_idx` (`equipment_id` ASC), 
  INDEX `fk_Characters_Competencies_idx` (`competencies_id` ASC),
  INDEX `fk_Characters_User_idx` (`user_id` ASC),
  CONSTRAINT `fk_Characters_Stats1`
    FOREIGN KEY (`stats_id`)
    REFERENCES `stats` (`stats_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Characters_Race1`
    FOREIGN KEY (`race_id`)
    REFERENCES `race` (`race_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Characters_CharacterClass1`
    FOREIGN KEY (`class_id`)
    REFERENCES `character_class` (`class_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Characters_Background1`
    FOREIGN KEY (`background_id`)
    REFERENCES `background` (`background_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Characters_Abilities1`
    FOREIGN KEY (`abilities_id`)
    REFERENCES `abilities` (`ability_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Characters_Equipment1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `equipment` (`equipment_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Characters_Competencies1`
    FOREIGN KEY (`competencies_id`)
    REFERENCES `competencies` (`competency_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Characters_User1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- Table `user`
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255),
  `email` VARCHAR(255),
  `password` VARCHAR(255),
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
);

-- Table `user_characters`
CREATE TABLE IF NOT EXISTS `user_characters` (
  `user_id` INT NOT NULL,
  `character_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `character_id`),
  INDEX `fk_user_has_characters_characters_idx` (`character_id` ASC),
  INDEX `fk_user_has_characters_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_characters_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_characters_characters1`
    FOREIGN KEY (`character_id`)
    REFERENCES `characters` (`character_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table `user_saved_characters`
CREATE TABLE IF NOT EXISTS `user_saved_characters` (
  `user_id` INT NOT NULL,
  `character_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `character_id`),
  INDEX `fk_user_has_characters1_characters_idx` (`character_id` ASC),
  INDEX `fk_user_has_characters1_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_characters1_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_characters1_characters1`
    FOREIGN KEY (`character_id`)
    REFERENCES `characters` (`character_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO `stats_change` (`stats_change_id`, `strength`, `dexterity`, `constitution`, `intelligence`, `wisdom`, `charisma`, `hit_points`) VALUES
(1, 0, 0, 0, 0, 0, 1, 1),
(2, 2, 0, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 1, 0, 0, 0),
(4, 0, 0, 0, 0, 1, 0, 0),
(5, 0, 0, 0, 0, 0, 1, 0),
(6, 0, 0, 0, 0, 0, 1, 0),
(7, 0, 0, 1, 0, 0, 0, 0),
(8, 1, 1, 1, 1, 1, 1, 0),
(9, 2, 0, 0, 0, 0, 1, 0),
(10, 0, 1, 0, 2, 0, 0, 0),
(11, 0, 0, 1, 2, 0, 0, 0),
(12, 0, 0, 0, 1, 1, 2, 0),
(13, 2, 0, 1, 0, 0, 0, 0),
(14, 0, 0, 0, 1, 0, 2, 0),
(15, 2, 0, 0, 0, 0, 1, 0);

INSERT INTO `race` (`race_id`, `name`, `race_selection`, `speed`, `abilities`, `competencies`, `stats_change_id`) VALUES
(1, 'Enano de las colinas', 1, 25, 'Visión en la oscuridad, Resistencia enana, Idiomas enano y común', 'Hachas, Martillos, Historia', 1),
(2, 'Enano de las montañas', 2, 25, 'Visión en la oscuridad, Resistencia enana, Idiomas enano y común', 'Hachas, Martillos, Historia, Armaduras ligeras y medias', 2),
(3, 'Alto elfo', 1, 30, 'Visión en la oscuridad, Ascendencia Peérica, Trance, Idiomas élfico, común y uno adicional', 'Percepción, Espada larga/corta, Arco largo/corto', 3),
(4, 'Elfo de los bosques', 2, 35, 'Visión en la oscuridad, Ascendencia Peérica, Trance, Máscara de la espesura, Idiomas élfico y común', 'Percepción, Espada larga/corta, Arco largo/corto', 4),
(5, 'Elfo oscuro', 3, 30, 'Visión en la oscuridad mejorada, Ascendencia Peérica, Trance, Desventaja bajo el sol, Idiomas élfico y común', 'Percepción, Espada corta, Estoque, Ballesta de mano', 5),
(6, 'Mediano piesligeros', 1, 25, 'Suerturo, Valiente, Agilidad mediana, Idiomas mediano y común', 'Sigilo', 6),
(7, 'Mediano fornido', 2, 25, 'Suerturo, Valiente, Agilidad mediana, Idiomas mediano y común', 'Resistencia al veneno', 7),
(8, 'Humano', 1, 30, 'Idioma común', '', 8),
(9, 'Dracónido', 1, 30, 'Ascendencia dracónida, Arma de aliento, Idiomas dracónido y común', '', 9),
(10, 'Gnomo de los bosques', 1, 25, 'Visión en la oscuridad, Astucia gnoma, Idiomas gnómico y común', '', 10),
(11, 'Gnomo de las rocas', 2, 25, 'Visión en la oscuridad, Astucia gnoma, Idiomas gnómico y común', 'Herramientas de artesano', 11),
(12, 'Semielfos', 1, 30, 'Visión en la oscuridad, Ascendencia feérica, Idiomas élfico, común y uno adicional', 'Ganas competencia en dos abilidades a tu elección', 12),
(13, 'Semielfos', 1, 30, 'Visión en la oscuridad, Resistencia insaciable, Ataques salvajes, Idiomas orco y común', 'Intimidación', 13),
(14, 'Tiflin', 1, 30, 'Visión en la oscuridad, Resistencia infernal, Legado infernal, Idiomas infernal y común', '', 14),
(15, 'Goliat', 1, 30, 'Resistencia al frio, Idiomas gigante y común', 'Atletismo', 15);

INSERT INTO `character_class` (`class_id`, `name`, `class_selection`, `dice_hit_points`, `equipment`, `competencies`, `abilities`) VALUES
(1, 'Bárbaro', 1, '1d12', 'Gran hacha, Espada corta, Equipo de explorador, 4 jabalinas', 'Armaduras ligeras/medias, Escudos, Armas simples/marciales', 'Dos entre: (Atletismo, Intimidar, Naturaleza, Percepción, Supervivencia y Trato con Animales)'),
(2, 'Bardo', 1, '1d8', 'Espada larga, Equipo de actor, Un intrumento musical, Armadura de cuero, Daga', 'Armaduras ligeras, Armas simples, Ballesta de mano, Espada larga/corta, Estoque, 3 instrumentos musicales', 'Inspiración bárdica'),
(3, 'Brujo', 1, '1d8', 'Ballesta ligera y 20 virotes, Bolsa de componentes, Equipo de erudito, Armadura de cuero, Estoque, 2 dagas', 'Armaduras ligeras, Armas sencillas', 'Dos entre: (Conocimiento arcano, Engañar, Historia, Intimidar, Investigación, Naturaleza y Religión)'),
(4, 'Clérigo', 1, '1d8', 'Martillo de guerra, Cota de malla, Espada corta, Equipo de explorador, Escudo, Símbolo sagrado', 'Armaduras ligeras/medias, Escudos, Armas simples', 'Dos entre: (Historia, Medicina, Perspicacia, Persuasión y Religión)'),
(5, 'Druida', 1, '1d8', 'Escudo de madera, Cimitarra, Armadura de cuero, Equipo de explorador, Foco druídico', 'Armaduras ligeras/medias (que no sean de metal), Escudos, Armas simples', 'Dos entre: (Conocimiento arcano, Medicina, Naturaleza, Percepción, Perspicacia, Religión, Supervivencia y Trato con Animales)'),
(6, 'Explorador', 1, '1d10', 'Cota de escamas, 2 espadas cortas, Equipo saqueador de tumbas, Arco largo y carcaj con 20 flechas', 'Armaduras ligeras/medias, Escudos, Armas simples, Armas marciales', 'Tres entre: (Atletismo, Investigación, Trato con Animales, Naturaleza, Percepción, Perspicacia, Sigilo y Supervivencia)'),
(7, 'Guerrero', 1, '1d10', 'Cota de malla, Bastón, Escudo, 2 hachas de mano, Equipo de explorador', 'Armaduras, Escudos, Armas simples, Armas marciales', 'Dos entre: (Acrobacias, Atletismo, Historia, Intimidación, Percepción, Perspicacia, Supervivencia y Trato con animales), Nuevas energías'),
(8, 'Hechicero', 1, '1d6', 'Ballesta ligera y 20 virotes, Foco arcano, Equipo de saqueador de tumbas, 2 dagas', 'Dagas, Dardos, Hondas, Bastones, Ballestas ligeras', 'Dos entre: (Conocimiento arcano, Engañar, Intimidación, Perspicacia, Persuasión y Religión)'),
(9, 'Mago', 1, '1d6', 'Bastón, Bolsa de componentes de conjuro, Equipo de erudito, Libro de conjuros', 'Dagas, Dardos, Hondas, Bastones, Ballestas ligeras', 'Dos entre: (Conocimiento arcano, Historia, Investigación, Medicina, Perspicacia y Religión), Recuperación arcana'),
(10, 'Monje', 1, '1d8', 'Espada corta, Equipo de saqueador de tumbas, 10 dardos', 'Armas simples, Un instrumento musical', 'Dos entre: (Acrobacias, Atletismo, Historia, Perspicacia, Religión y Sigilo), Artes marciales'),
(11, 'Paladín', 1, '1d10', 'Arma marcial, Escudo, 5 jabalinas, Equipo de sacerdote, Cota de mallas, Símbolo sagrado', 'Armaduras, Escudos, Armas simples, Armas marciales', 'Dos entre: (Atletismo, Intimidar, Medicina, Perspicacia, Persuasión y Religión), Sentido divino'),
(12, 'Pícaro', 1, '1d8', 'Estoque, Espada corta, Equipo de ladrón, Armadura de cuero, 2 dagas, Herramientas de ladrón', 'Armadura ligera, Armas simples, Ballesta corta', 'Cuatro entre: (Acrobacias, Atletismo, Engañar, Interpretación, Intimidar, Investigación, Juego de Manos, Percepción, Perspicacia, Persuasión y Sigilo), Experto, Ataque furtivo, Jerga de ladrones');

INSERT INTO `background` (`background_id`, `name`, `equipment`, `competencies`) VALUES
(1, 'Acólito', 'Libro de oraciones, Vestiduras, Ropa común, Bolsa con 15 monedas de oro', 'Perspicacia, Religión'),
(2, 'Artesano gremial', 'Herramientas de artesano, Carta de introducción a tu gremio, Mudas de viaje, Bolsa con 15 monedas de oro', 'Perspicacia, Persuación'),
(3, 'Artista', 'Algo de un admirador, Traje, Bolsa con 15 monedas de oro', 'Acrobacias, Interpretación'),
(4, 'Charlatán', 'Kit de disfraz, Dados cargados, Baraja de cartas marcadas, Bolsa con 15 monedas de oro', 'Engañar, Juego de manos'),
(5, 'Ermitaño', 'Pergamino con tus estudios o plegarias, Kit de herboristería, Bolsa con 5 monedas de oro', 'Medicina, Religión'),
(6, 'Fronterizo', 'Trampa de caza, Trofeo de animal que mataste, Ropa de viajero, Bolsa con 10 monedas de oro', 'Atletismo, Supervivencia'),
(7, 'Héroe del pueblo', 'Herramientas de artesano, Olla de hierro, Pala, Ropa común, Bolsa con 10 monedas de oro', 'Trato con animales, Supervivencia'),
(8, 'Huérfano', 'Cuchillo, Mapa de tu ciudad natal, Ratón como mascota, Recuerdo de tus padres, Ropa común, Bolsa con 10 monedas de oro', 'Juego de manos, Sigilo'),
(9, 'Marinero', 'Barra de metal, 50 pies de cuerda, Amuleto de la suerte, Bolsa con 10 monedas de oro', 'Atletismo, Percepción'),
(10, 'Noble', 'Ropa fina, Anillo con sello, Pergamino familiar, Bolsa con 25 monedas de oro', 'Historia, Persuación'),
(11, 'Sabio', 'Tintero, Pluma, Recuerdo de un amigo fallecido, Cuchillo, Bolsa con 10 monedas de oro', 'Arcano, Historia'),
(12, 'Soldado', 'Insignia de tu rango, Trofeo de un enemigo caído, Baraja de cartas, Bolsa con 10 monedas de oro', 'Atletismo, Intimidar');

SET FOREIGN_KEY_CHECKS = 1;
