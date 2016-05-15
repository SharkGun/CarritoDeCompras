/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


CREATE DATABASE `bdcarrito` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bdcarrito`;
CREATE TABLE `detalleventa` (
  `codigoVenta` int(11) NOT NULL,
  `codigoProducto` int(11) NOT NULL,
  `cantidad` decimal(18,2) NOT NULL,
  `descuento` decimal(18,2) NOT NULL,
  PRIMARY KEY (`codigoVenta`,`codigoProducto`),
  KEY `FK_DetalleVenta_Producto` (`codigoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `detalleventa` VALUES (1,3,4,100);
INSERT INTO `detalleventa` VALUES (1,4,2,34.53);
INSERT INTO `detalleventa` VALUES (1,5,2,0);
CREATE TABLE `producto` (
  `codigoProducto` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(18,2) NOT NULL,
  `imagen` varchar(20) NOT NULL,
  PRIMARY KEY (`codigoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `producto` VALUES (1,'TECLADO',18.44,'teclado');
INSERT INTO `producto` VALUES (2,'MOUSE',15.34,'mouse');
INSERT INTO `producto` VALUES (3,'MONITOR',500,'monitor');
INSERT INTO `producto` VALUES (4,'SCANNER',345.33,'scanner');
INSERT INTO `producto` VALUES (5,'LAPIZ OPTICO',22,'lapiz');
INSERT INTO `producto` VALUES (6,'Placa',145,'placa');
INSERT INTO `producto` VALUES (7,'Memoria Usb',22,'memoriaUsb');
INSERT INTO `producto` VALUES (8,'Memoria SD',26,'memoriaSD');
CREATE TABLE `venta` (
  `codigoVenta` int(11) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`codigoVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `venta` VALUES (1,'FFFFFF','2014-06-09');

CREATE DEFINER=`root`@`localhost` PROCEDURE `spU_producto`(
   _codigoProducto  int ,
   _nombre  varchar(100) ,
   _precio  decimal(18, 2)
)
BEGIN

UPDATE producto
SET 
   `nombre` = _nombre,
   `precio` = _precio
WHERE
    `codigoProducto` = _codigoProducto
;
END;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spI_venta`(
   INOUT _codigoVenta  int ,
   _cliente  varchar(100) 
)
BEGIN
-- Codigo autogenerado
SELECT IFNULL(MAX(codigoVenta),0)+1 into _codigoVenta FROM `venta`;
INSERT INTO `venta`(
   `codigoVenta`,
   `cliente`,
   `fecha`
)
VALUES (
   _codigoVenta,
   _cliente,
   CURDATE()
);
END;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spI_producto`(
   INOUT _codigoProducto  int ,
   _nombre  varchar(100) ,
   _precio  decimal(18, 2),
   _imagen  varchar(100)
)
BEGIN
-- Genera una especie de autoincremental para los codigos
-- que se genera
SELECT IFNULL(MAX(codigoProducto),0)+1 into _codigoProducto FROM `producto`;
INSERT INTO `producto`(
   `codigoProducto`,
   `nombre`,
   `precio`,   
   `imagen`
)
VALUES (
   _codigoProducto,
   _nombre,
   _precio,   
   _imagen
);
END;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spI_detalleventa`(
   _codigoVenta  int ,
   _codigoProducto  int ,
   _cantidad  decimal(18, 2) ,
   _descuento  decimal(18, 2)
)
BEGIN

INSERT INTO `detalleventa`(
   `codigoVenta`,
   `codigoProducto`,
   `cantidad`,
   `descuento`
)
VALUES (
   _codigoVenta,
   _codigoProducto,
   _cantidad,
   _descuento
);
END;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spF_Ventas_all`()
SELECT * FROM venta;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spF_venta_one`(
  _codigoVenta  int
)
BEGIN
SELECT
    v.codigoVenta AS CodigoVenta,
    v.cliente AS Cliente, 
    v.fecha AS Fecha, 
    d.codigoProducto AS CodigoProducto, 
    p.nombre AS Nombre,
    p.precio AS Precio, 
    d.cantidad AS Cantidad, 
    d.descuento AS Descuento,
    p.precio*d.cantidad AS Parcial,
    ((p.precio*d.cantidad)-d.descuento) AS SubTotal,
    (
    SELECT     
        SUM((dT.cantidad * pT.precio)-dT.descuento) AS TotalPagar
    FROM         
        DetalleVenta AS dT INNER JOIN
        Producto AS pT ON dT.codigoProducto = pT.codigoProducto
    WHERE
        dT.codigoVenta=v.codigoVenta
    ) AS TotalPagar
FROM 
    Venta AS v INNER JOIN
    DetalleVenta AS d ON v.codigoVenta = d.codigoVenta INNER JOIN
    Producto AS p ON d.codigoProducto = p.codigoProducto
WHERE
    v.codigoVenta=_codigoVenta
ORDER BY
    Nombre
;
END;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spF_venta_All`(
)
BEGIN
SELECT
    v.codigoVenta AS CodigoVenta,
    v.cliente AS Cliente, 
    v.fecha AS Fecha,
    d.codigoProducto AS CodigoProducto, 
    p.nombre AS Nombre,
    p.precio AS Precio, 
    d.cantidad AS Cantidad,
    d.descuento AS Descuento,
    p.precio*d.cantidad AS Parcial,
    ((p.precio*d.cantidad)-d.descuento) AS SubTotal,
    (
    SELECT     
        SUM((dT.cantidad * pT.precio)-dT.descuento) AS TotalPagar
    FROM         
        DetalleVenta AS dT INNER JOIN
        Producto AS pT ON dT.codigoProducto = pT.codigoProducto
    WHERE
        dT.codigoVenta=v.codigoVenta
    ) AS TotalPagar
FROM 
    Venta AS v INNER JOIN
    DetalleVenta AS d ON v.codigoVenta = d.codigoVenta INNER JOIN
    Producto AS p ON d.codigoProducto = p.codigoProducto
ORDER BY
    CodigoVenta, Nombre
 ;
END;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spF_producto_one`(
_codigoProducto  int 
)
BEGIN

SELECT
    p.codigoProducto,
    p.nombre,
    p.precio,    
    p.imagen
FROM
    producto p
WHERE
    p.codigoProducto = _codigoProducto
ORDER BY
    P.nombre

;
END;


CREATE DEFINER=`root`@`localhost` PROCEDURE `spF_producto_all`(
)
BEGIN

SELECT
    p.codigoProducto,
    p.nombre,
    p.precio,    
    p.imagen
FROM
    producto p
ORDER BY
    P.nombre

;
END;


ALTER TABLE `detalleventa`
ADD CONSTRAINT `FK_DetalleVenta_Producto` FOREIGN KEY (`codigoProducto`) REFERENCES `producto` (`codigoProducto`),
ADD CONSTRAINT `FK_DetalleVenta_Venta` FOREIGN KEY (`codigoVenta`) REFERENCES `venta` (`codigoVenta`);


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
