SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS lanka;
DROP TABLE IF EXISTS ohje;
DROP TABLE IF EXISTS vari;
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
  PRIMARY KEY (lanka_id);

INSERT INTO lanka(merkki, malli, koostumus, luokittelu, neuletiheys, suositus, paino, pituus)
VALUES	('Novita', '7 veljestä', '75 % villaa, 25 % polyamidia', 'Aran (8 wpi)', '18 s / 10 cm', 'Puikot kokoa 3,5', 100, 200);
		
CREATE TABLE ohje (
  ohje_id bigint(20) NOT NULL AUTO_INCREMENT,
  suunnittelija varchar(200) NOT NULL,
  nimi varchar(200) NOT NULL,
  lahde varchar(600) NOT NULL,
  luokittelu varchar(200) NOT NULL,
  tarvittava_maara int(11),
  PRIMARY KEY (ohje_id);
  
INSERT INTO ohje(suunnittelija, nimi, lahde, luokittelu, tarvittava_maara)
VALUES 	('Jonas Matthies', 'Book Rat', 'https://www.supergurumi.com/amigurumi-crochet-rat-bookmark', 'Sport (12 wpi)', 0);
		
CREATE TABLE vari (
  vari_id bigint(20) NOT NULL AUTO_INCREMENT,
  vari varchar(200) NOT NULL,
  maara_varastossa int(11) NOT NULL,
  lanka_id bigint(20) NOT NULL,
  PRIMARY KEY (vari_id) USING BTREE,
  KEY FK_vari_lanka (lanka_id),
  CONSTRAINT FK_vari_lanka FOREIGN KEY (lanka_id) REFERENCES lanka (lanka_id) ON DELETE NO ACTION ON UPDATE NO ACTION);

INSERT INTO vari(vari, maara_varastossa)
VALUES	('Auringonkukka', 50, 1);
		
SELECT * FROM lanka;
SELECT * FROM ohje;
SELECT * FROM vari;
