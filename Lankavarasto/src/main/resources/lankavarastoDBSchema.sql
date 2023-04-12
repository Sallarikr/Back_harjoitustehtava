SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS lanka;
DROP TABLE IF EXISTS ohje;
DROP TABLE IF EXISTS vari;
DROP TABLE IF EXISTS appuser;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE lanka (
  lanka_id bigint(20) NOT NULL AUTO_INCREMENT,
  merkki varchar(200) NOT NULL,
  malli varchar(200) NOT NULL,
  koostumus varchar(200) NOT NULL,
  luokittelu varchar(200) NOT NULL,
  neuletiheys varchar(200) NOT NULL,
  suositus varchar(200) NOT NULL,
  paino int(11) NOT NULL DEFAULT 0,
  pituus int(11) NOT NULL DEFAULT 0,
  vari_id bigint(20) NOT NULL,
  PRIMARY KEY (lanka_id));
 
INSERT INTO lanka(merkki, malli, koostumus, luokittelu, neuletiheys, suositus, paino, pituus)
VALUES	('Novita', '7 veljestä', '75 % villaa, 25 % polyamidia', 'Aran (8 wpi)', '18 s / 10 cm', 'Puikot kokoa 3,5', 100, 200);
		
CREATE TABLE ohje (
  ohje_id bigint(20) NOT NULL AUTO_INCREMENT,
  suunnittelija varchar(200) NOT NULL,
  nimi varchar(200) NOT NULL,
  lahde varchar(600) NOT NULL,
  luokittelu varchar(200) NOT NULL,
  PRIMARY KEY (ohje_id));
  
INSERT INTO ohje(suunnittelija, nimi, lahde, luokittelu)
VALUES 	('Jonas Matthies', 'Book Rat', 'https://www.supergurumi.com/amigurumi-crochet-rat-bookmark', 'Sport (12 wpi)', 0);
		
CREATE TABLE vari (
  vari_id bigint(20) NOT NULL AUTO_INCREMENT,
  vari varchar(200) NOT NULL,
  maara_varastossa int(11) NOT NULL,
  lanka_id bigint(20) NOT NULL,
  PRIMARY KEY (vari_id),
  FOREIGN KEY (lanka_id) REFERENCES lanka (lanka_id)););

INSERT INTO vari(vari, maara_varastossa)
VALUES	('Auringonkukka', 50, 1);

CREATE TABLE appuser (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL DEFAULT '',
  password varchar(250) NOT NULL DEFAULT '',
  role varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (appUser_id)
);

INSERT INTO appuser(username, password, role)
VALUES	('admin', '$2a$10$kE3Y6Gh8P.W4qakG/81mTORMkgkkNhS32mWUrhiErmwJu7e1Nw6BO', 'ADMIN' ),
		('user', '$2a$10$CT0JYNmW1vSYrgog9l27o.eGVc434PStoolCqSVplOLtt0CH628/O', 'USER');
		
SELECT * FROM lanka;
SELECT * FROM ohje;
SELECT * FROM vari;
SELECT * FROM appuser;
