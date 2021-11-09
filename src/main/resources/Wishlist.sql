CREATE DATABASE `wishlist` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE wishlist;
CREATE TABLE `accounts` (
  `accountid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `wishlist` (
  `idWishlist` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  PRIMARY KEY (`idWishlist`),
  FOREIGN KEY (userId) REFERENCES accounts (accountid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `wishes` (
  `idWish` int NOT NULL AUTO_INCREMENT,
  `idWishlist` int NOT NULL,
  `wish` varchar(45) DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`idWish`),
  FOREIGN KEY (idWishlist) references wishlist (idWishList)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
