CREATE DATABASE rosita;
USE rosita;

CREATE TABLE Proveedor(
idProveedor INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
tipoDocumentoProveedor VARCHAR(40) NOT NULL,
documentoProveedor VARCHAR(50) NOT NULL,
nombreProveedor VARCHAR(50) NOT NULL,
telefonoProveedor VARCHAR(50) NOT NULL,
direccionProveedor MEDIUMTEXT
);

CREATE TABLE Producto(
idProducto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombreProducto VARCHAR(50) NOT NULL,
marcaProducto VARCHAR (50)NOT NULL,
stockProducto INT NOT NULL,
costoProducto FLOAT NOT NULL,
precioProducto FLOAT NOT NULL,
idProveedor INT NOT NULL, 

CONSTRAINT fk_idProveedor FOREIGN KEY (idProveedor)
	REFERENCES Proveedor(idProveedor)
	ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Venta(
    idVenta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fechaVenta DATE NOT NULL,   
    horaVenta TIME NOT NULL,     
    totalVenta FLOAT NOT NULL
);

CREATE TABLE DetalleVenta(
idDV INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
cantidadDV INT NOT NULL,
precioUnitarioDV FLOAT NOT NULL,
subTotalDV FLOAT NOT NULL,
idProductoDV INT NOT NULL,
idVentaDV INT NOT NULL,

CONSTRAINT fk_idVentaDV FOREIGN KEY (idVentaDV)
	REFERENCES Venta(idVenta)
	ON DELETE CASCADE ON UPDATE CASCADE,

CONSTRAINT fk_idProductoDV FOREIGN KEY (idProductoDV)
	REFERENCES Producto(idProducto)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Compra (
idCompra INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
fechaCompra DATE NOT NULL,
horaCompra TIME NOT NULL,
totalCompra FLOAT NOT NULL 
);

CREATE TABLE DetalleCompra(
idDC INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
cantidadDC INT NOT NULL,
costoUnitarioDC FLOAT NOT NULL,
subTotalDC FLOAT NOT NULL,
idCompraDC INT NOT NULL,
idProductoDC INT NOT NULL,

CONSTRAINT fk_idCompraDC FOREIGN KEY (idCompraDC)
	REFERENCES Compra(idCompra)
	ON DELETE CASCADE ON UPDATE CASCADE,

CONSTRAINT fk_idProductoDC FOREIGN KEY (idProductoDC)
	REFERENCES Producto(idProducto)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Gasto (
idGasto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
fechaGasto DATE,
horaGasto TIME,
descripcionGasto MEDIUMTEXT,				
valorGasto FLOAT
);

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    UserName VARCHAR(50) UNIQUE NOT NULL,
    passwordName VARCHAR(255) NOT NULL,
    pregunta_seguridad VARCHAR(255) NOT NULL
);

INSERT INTO usuarios (UserName, passwordName, pregunta_seguridad)
VALUES ('Rosita', SHA2('12345', 256), 'Samuel');

