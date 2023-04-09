SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS lanka;
DROP TABLE IF EXISTS ohje;
DROP TABLE IF EXISTS vari;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `lanka` (
  `lanka_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merkki` varchar(200) NOT NULL,
  `malli` varchar(200) NOT NULL,
  `koostumus` varchar(200) NOT NULL,
  `luokittelu` varchar(200) NOT NULL,
  `neuletiheys` varchar(200) NOT NULL,
  `suositus` varchar(200) NOT NULL,
  `paino` int(11) NOT NULL DEFAULT 0,
  `pituus` int(11) NOT NULL DEFAULT 0,
  `pesuohje` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`lanka_id`);

INSERT INTO lanka(merkki, malli, koostumus, luokittelu, neuletiheys, suositus, paino, pituus, pesuohje)
VALUES	('Novita', '7 veljestä', '75 % villaa, 25 % polyamidia', 'Aran (8 wpi)', '18 s / 10 cm', 'Puikot kokoa 3,5', 100, 200, 40),
		('Novita', 'Nalle', '75 % villaa, 25 % polyamidia', 'DK (11 wpi)', '22 s / 10 cm', 'Puikot kokoa 3,5', 100, 260, 40),
		('Cotton Kings', 'Sultan Deluxe', '100 % puuvillaa', 'Sport (12wpi)', '24-26 s / 10 cm', 'Virkkuukoukku kokoa 2,5 - 3,5', 200, 999, 30),
		('Hobbii', 'Honey Bunny', '100 % polyesteriä', 'Super Bulky (5-6 wpi)', '7-12 s / 10 cm', 'Virkkuukoukku kokoa 6', 100, 120, 40);

CREATE TABLE `ohje` (
  `ohje_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suunnittelija` varchar(200) NOT NULL,
  `nimi` varchar(200) NOT NULL,
  `lahde` varchar(600) NOT NULL,
  `luokittelu` varchar(200) NOT NULL,
  `tarvittava_maara` int(11),
  PRIMARY KEY (`ohje_id`);
  
INSERT INTO ohje(suunnittelija, nimi, lahde, luokittelu, tarvittava_maara)
VALUES 	('Jonas Matthies', 'Book Rat', 'https://www.supergurumi.com/amigurumi-crochet-rat-bookmark', 'Sport (12 wpi)'),
		('Maz Kwok', 'Enchanted Sun Dress ', 'https://beacrafter.com/crochet-enchanted-sun-dress/', 'Sport (12 wpi)', 500),
		('Lumi Karmitsa', 'Kosiomatkalapaset ', 'Lumi Karmitsa: Villit vanttuut & vallattomat villasukat 3', 'Light Fingering'),
		('Heidi Bears', 'Tomato the Frog Prince', 'https://www.ravelry.com/patterns/library/tomato-the-frog-prince-african-flower', 'Fingering (14 wpi)', 130);

CREATE TABLE IF NOT EXISTS `vari` (
  `vari_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lanka_id` bigint(20) NOT NULL DEFAULT 0,
  `vari` varchar(200) NOT NULL,
  `maara_varastossa` int(11) NOT NULL,
  PRIMARY KEY (`vari_id`) USING BTREE,
  KEY `FK_vari_lanka` (`lanka_id`),
  CONSTRAINT `FK_vari_lanka` FOREIGN KEY (`lanka_id`) REFERENCES `lanka` (`lanka_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO vari(lanka_id, vari, maara_varastossa)
VALUES	(1, 'Auringonkukka', 35),
		(3, 'Peach Beryl', 200),
		(3, 'Fire Opal', 200),
		(4, 'Shamrock', 200);
		
SELECT * FROM lanka;
SELECT * FROM ohje;
SELECT * FROM vari;