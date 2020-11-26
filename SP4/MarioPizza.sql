
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+02:00";

CREATE DATABASE IF NOT EXISTS `MarioPizza` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `MarioPizza`;


CREATE TABLE `Menu` (
  `PizzaID` int(100) KEY NOT NULL AUTO_INCREMENT,
  `PizzaName` varchar(255) DEFAULT NULL,
  `PizzaIngredients` varchar(255) DEFAULT NULL,
  `PizzaPrice` int(100) NOT NULL
) DEFAULT CHARSET=utf8;

INSERT INTO `Menu` (`PizzaID`, `PizzaName`, `PizzaIngredients`,`PizzaPrice`) VALUES
(1, 'Margherita','Tomatsauce og ost',49),
(2, 'Vesuvio', 'Tomatsauce, ost og skinke',49),
(3, 'Hawaii', 'Tomatsauce, ost, skinke og ananas',69),
(4, 'Pepperoni', 'Tomatsauce, ost og Pepperoni',59),
(5, 'Milano', 'Tomatsauce, ost, Pepperoni, oksekød og skinke',69),
(6, 'Carbonara', 'Tomatsauce, ost, kødsauce og løg',69);

CREATE TABLE `Orders` (
  `OrderID` int(100) KEY NOT NULL AUTO_INCREMENT,
  `PhoneNumber` varchar(255) DEFAULT NULL,
  `Pizza` varchar(255) DEFAULT NULL,
  `PizzaPrice` int(100) NOT NULL,
  `PickupTime` timestamp default now()
) DEFAULT CHARSET=utf8;

