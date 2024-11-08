-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2024 a las 13:53:42
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alemesas3dplace`
--
CREATE DATABASE IF NOT EXISTS `alemesas3dplace` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `alemesas3dplace`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id_detalle` int(11) NOT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `Color` varchar(20) DEFAULT NULL,
  `Material` varchar(20) DEFAULT NULL,
  `Pintado` varchar(2) DEFAULT NULL,
  `Terminado` varchar(20) DEFAULT NULL
) ;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id_detalle`, `id_pedido`, `Color`, `Material`, `Pintado`, `Terminado`) VALUES
(38, 58, 'Amarillo', 'Resina', 'Si', 'En proceso'),
(40, 59, 'Amarillo', 'Filamento', 'Si', 'Sin empezar'),
(41, 60, 'Negro', 'Resina', 'Si', 'Si'),
(42, 61, 'Rojo', 'Filamento', 'Si', 'En proceso'),
(45, 62, 'Naranja', 'Resina', 'Si', 'Sin empezar'),
(46, 63, 'Rojo', 'Filamento', 'Si', 'Si'),
(48, 64, 'Verde', 'Resina', 'Si', 'En proceso'),
(49, 65, 'Azul', 'Filamento', 'Si', 'Sin empezar'),
(50, 66, 'Negro', 'Filamento', 'Si', 'En proceso'),
(52, 67, 'Azul', 'Resina', 'Si', 'Sin empezar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id_pedido` int(11) NOT NULL,
  `Nombre_Pedido` varchar(30) DEFAULT NULL,
  `Precio` int(11) DEFAULT NULL,
  `Fecha_envio` date DEFAULT NULL,
  `Estado` varchar(20) DEFAULT NULL,
  `Fecha_llegada` date DEFAULT NULL,
  `Notas` varchar(255) DEFAULT NULL,
  `Direccion_del_pedido` varchar(255) DEFAULT NULL,
  `Metodo_pago` varchar(50) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `Cantidad` int(11) NOT NULL
) ;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id_pedido`, `Nombre_Pedido`, `Precio`, `Fecha_envio`, `Estado`, `Fecha_llegada`, `Notas`, `Direccion_del_pedido`, `Metodo_pago`, `id_cliente`, `Cantidad`) VALUES
(58, 'Figura de Goku', 50, '2024-06-01', 'En camino', '2024-06-05', 'Versión Super Saiyan', '123 Calle Falsa, Ciudad', 'Tarjeta de crédito', 1, 2),
(59, 'Figura de Pikachu', 30, '2024-06-02', 'Preparando', NULL, 'Edición especial', '456 Avenida Verdadera, Ciudad', 'Paypal', 11, 1),
(60, 'Figura de Darth Vader', 70, '2024-06-01', 'Entregado', '2024-06-03', 'Con luces LED', '789 Calle del Espacio, Ciudad', 'Tarjeta de crédito', 12, 1),
(61, 'Figura de Luffy', 40, '2024-05-30', 'En camino', '2024-06-03', 'Con sombrero de paja', '1010 Avenida Grande, Ciudad', 'Paypal', 21, 3),
(62, 'Figura de Naruto', 35, '2024-05-31', 'Problema', NULL, 'Versión Hokage', '1111 Calle Ninja, Ciudad', 'Tarjeta de crédito', 22, 1),
(63, 'Figura de Iron Man', 65, '2024-05-29', 'Entregado', '2024-06-01', 'Mark 50 Armor', '1212 Avenida Marvel, Ciudad', 'Paypal', 1, 2),
(64, 'Figura de Yoda', 55, '2024-06-01', 'En camino', '2024-06-04', 'Con sable láser', '1313 Calle Jedi, Ciudad', 'Tarjeta de crédito', 11, 1),
(65, 'Figura de Zelda', 45, '2024-06-02', 'Preparando', NULL, 'Versión Breath of the Wild', '1414 Calle Hyrule, Ciudad', 'Paypal', 12, 1),
(66, 'Figura de Batman', 60, '2024-06-01', 'En camino', '2024-06-05', 'Con capa de tela', '1515 Avenida Gotham, Ciudad', 'Tarjeta de crédito', 21, 2),
(67, 'Figura de Sonic', 25, '2024-06-03', 'Preparando', NULL, 'Versión clásica', '1616 Calle Sega, Ciudad', 'Paypal', 22, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id` int(11) NOT NULL,
  `Usuario` varchar(25) DEFAULT NULL,
  `Contraseña` varchar(40) DEFAULT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  `correo_electronico` varchar(60) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Pais` varchar(20) NOT NULL,
  `Ciudad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id`, `Usuario`, `Contraseña`, `Fecha_Creacion`, `correo_electronico`, `Direccion`, `Pais`, `Ciudad`) VALUES
(1, 'Alemesa', '1234', '2024-05-09', '', '', '', ''),
(11, 'Sergio', '123456', '2024-05-13', 'Sergio@gmail.com', 'Oficina', 'España', 'Badajoz'),
(12, 'Aitor', '12345', '2024-05-17', 'aitor@gmail.com', 'Direccion aitor', 'España', 'Cáceres'),
(21, 'Sanhehi', 'pipopi', '2024-05-31', 'sanchanfangirl@gmail.com', 'Avenida Gatuna', 'España', 'Cáceres'),
(22, 'Vargues', '4321', '2024-05-31', 'Vargues@gmail.com', 'Caceres', 'España', 'Caceres');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `id_pedido` (`id_pedido`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Usuario` (`Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuarios` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
