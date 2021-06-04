--========================================================================================================
--                                     Proyecto 3 de Bases de datos                                     --      
--========================================================================================================
--  Nombre Grupo: Maria Madre de Dios ruega por nosotros los desarrolladores                            --
--  Nombres:                                                                                            --
--      1. Juan Sebastian Barreto Jimenez:                                                              -- 
--      2. Janet Chen He:                                                                               --
--      3. Maria Jose Nino Rodriguez:                                                                   --
--      4. Maria Kamila Obregon Ortega:                                                                 --
--      5. David Santiago Quintana Echavarria                                                           --
--  Fecha: Junio 4 de 2021                                                                              --
--========================================================================================================
--========================================================================================================
--                                     Limpieza de la base de datos                                     --
--========================================================================================================
-- Eliminacion de restricciones --
ALTER TABLE Linea DROP CONSTRAINT asociado;
ALTER TABLE Linea DROP CONSTRAINT contiene;
ALTER TABLE BilletesXRenta DROP CONSTRAINT pertenece;
ALTER TABLE Renta DROP CONSTRAINT posee;
ALTER TABLE BilletesXRenta DROP CONSTRAINT "se paga";

-- Eliminacion de tablas --
DROP TABLE Billete;
DROP TABLE BilletesXRenta;
DROP TABLE Carro;
DROP TABLE Linea;
DROP TABLE Parametro;
DROP TABLE Renta;

--========================================================================================================
--                                          Creacion de tablas                                          --
--========================================================================================================
--- Creacion tabla Billete ---
CREATE TABLE Billete (
  Id           INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  Cantidad     INTEGER NOT NULL, 
  Denominacion INTEGER NOT NULL UNIQUE, 
  PRIMARY KEY (Id), 
  CONSTRAINT Check_Denominacion_Billete 
    CHECK (Denominacion in (1000,2000,5000,10000,20000,50000,100000)));
--- Creacion tabla BilletesXRenta ---
CREATE TABLE BilletesXRenta (
  Rentanumero INTEGER NOT NULL, 
  BilleteId   INTEGER NOT NULL, 
  Cantidad    INTEGER NOT NULL, 
  PRIMARY KEY (Rentanumero, 
  BilleteId));
--- Creacion tabla Carro ---
CREATE TABLE Carro (
  Id                  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  Placa               VARCHAR(10) NOT NULL UNIQUE, 
  UnidadesDisponibles INTEGER NOT NULL, 
  Precio              INTEGER NOT NULL, 
  Puestos             INTEGER NOT NULL, 
  PRIMARY KEY (Id));
--- Creacion tabla Linea ---
CREATE TABLE Linea (
  Numero      INTEGER NOT NULL, 
  Rentanumero INTEGER NOT NULL, 
  CarroId     INTEGER NOT NULL, 
  Cantidad    INTEGER NOT NULL, 
  PRIMARY KEY (Numero, 
  Rentanumero));
--- Creacion tabla Parametro ---
CREATE TABLE Parametro (
  Id         INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  Valor      INTEGER NOT NULL, 
  TasaCarros INTEGER NOT NULL, 
  PRIMARY KEY (Id), 
  CONSTRAINT Check_Valor_Parametro 
    CHECK (Valor in (5,10)));
CREATE TABLE Renta (
  Numero      INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  Fecha       DATE,
  Hora        TIME,
  ParametroId INTEGER, 
  PRIMARY KEY (Numero));
--- Creacion tabla Renta ---


--========================================================================================================
--                                        Alteraciones de tablas                                        --
--========================================================================================================
ALTER TABLE Linea ADD CONSTRAINT asociado FOREIGN KEY (CarroId) REFERENCES Carro (Id);
ALTER TABLE Linea ADD CONSTRAINT contiene FOREIGN KEY (Rentanumero) REFERENCES Renta (Numero);
ALTER TABLE BilletesXRenta ADD CONSTRAINT pertenece FOREIGN KEY (BilleteId) REFERENCES Billete (Id);
ALTER TABLE Renta ADD CONSTRAINT posee FOREIGN KEY (ParametroId) REFERENCES Parametro (Id);
ALTER TABLE BilletesXRenta ADD CONSTRAINT "se paga" FOREIGN KEY (Rentanumero) REFERENCES Renta (Numero);

--========================================================================================================
--                                         Insercion de tuplas                                          --
--========================================================================================================
--- Creacion tabla Carro ---
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('ABC123',1,100000,4);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('FYE843',1,200000,10);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('JST946',1,450000,7);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('HDE543',1,840000,3);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('BCX736',1,104000,8);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('JST299',1,970000,2);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('WER773',0,1100000,14);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('YUH121',1,750000,3);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('HHV808',1,940000,0);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('DSQ829',1,1500000,2);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('ADC123',1,200000,4);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('FDE843',1,500000,3);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('JDT946',1,650000,5);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('HDE573',1,840000,3);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('BDX736',1,404000,1);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('JDT299',1,370000,8);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('WDR773',1,1100000,10);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('YDH121',1,850000,1);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('HDV808',1,640000,5);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('DDQ829',1,6500000,2);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('ADC163',1,200000,4);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('FDE863',1,500000,3);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('JDT966',1,650000,5);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('HDE563',1,840000,3);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('BDX766',1,404000,1);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('JDT269',1,370000,8);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('WDR763',1,1100000,10);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('YDH161',1,850000,1);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('HDV868',1,640000,5);
INSERT INTO Carro (Placa,UnidadesDisponibles,Precio,Puestos) VALUES ('DDQ869',1,6500000,2);
--- Creacion tabla Billete	 ---
INSERT INTO Billete (Cantidad, Denominacion)  VALUES (10, 1000);
INSERT INTO Billete (Cantidad, Denominacion)  VALUES (20, 2000);
INSERT INTO Billete (Cantidad, Denominacion)  VALUES (50, 5000);
INSERT INTO Billete (Cantidad, Denominacion)  VALUES (30, 10000);
INSERT INTO Billete (Cantidad, Denominacion)  VALUES (22, 20000);
INSERT INTO Billete (Cantidad, Denominacion)  VALUES (150, 50000);
--- Creacion tabla Parametro ---
INSERT INTO Parametro (Valor, TasaCarros) VALUES (10, 10);
INSERT INTO Parametro (Valor, TasaCarros) VALUES (5, 5);
