--========================================================================================================
--                                     Proyecto 3 de Bases de datos                                     --      
--========================================================================================================
--  Nombre Grupo: Maria Madre de Dios ruega por nosotros los desarrolladores                            --
--  Nombres:                                                                                            --
--      1. Juan Sebastian Barreto Jimenez: CO_A850_SQL_S05                                              -- 
--      2. Janet Chen He: CO_A850_SQL_S09                                                               --
--      3. Maria Jose Nino Rodriguez: CO_A850_SQL_S17                                                   --
--      4. Maria Kamila Obregon Ortega: CO_A850_SQL_S18                                                 --
--      5. David Santiago Quintana Echavarria: CO_A850_SQL_S20                                          --
--  Fecha: Junio 4 de 2021                                                                             --
--========================================================================================================
--========================================================================================================
--                                     Limpieza de la base de datos                                     --
--========================================================================================================
-- Eliminacion de tablas --
DROP TABLE Billete CASCADE CONSTRAINTS;
DROP TABLE BilletesXRenta CASCADE CONSTRAINTS;
DROP TABLE Carro CASCADE CONSTRAINTS;
DROP TABLE Linea CASCADE CONSTRAINTS;
DROP TABLE Parametro CASCADE CONSTRAINTS;
DROP TABLE Periodo CASCADE CONSTRAINTS;
DROP TABLE Renta CASCADE CONSTRAINTS;

--========================================================================================================
--                                          Creacion de tablas                                          --
--========================================================================================================
--- Creacion tabla Billete ---
CREATE TABLE Billete (
  Id           INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  Cantidad     INTEGER NOT NULL, 
  Denominacion number(6) NOT NULL UNIQUE, 
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
  Placa               varchar2(10) NOT NULL UNIQUE, 
  UnidadesDisponibles number(1) NOT NULL, 
  Precio              INTEGER NOT NULL, 
  Puestos             number(2) NOT NULL, 
  PRIMARY KEY (Id));
--- Creacion tabla Linea ---
CREATE TABLE Linea (
  Numero      INTEGER NOT NULL, 
  Rentanumero INTEGER NOT NULL, 
  CarroId     INTEGER NOT NULL, 
  Cantidad    number(2) NOT NULL, 
  PRIMARY KEY (Numero, 
  Rentanumero));
--- Creacion tabla Parametro ---
CREATE TABLE Parametro (
  Id         INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  Valor      number(3) NOT NULL, 
  TasaCarros number(4) NOT NULL, 
  PRIMARY KEY (Id), 
  CONSTRAINT Check_Valor_Parametro 
    CHECK (Valor in (5,10)));
--- Creacion tabla Periodo ---
CREATE TABLE Periodo (
  Id    INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  Fecha date NOT NULL UNIQUE, 
  PRIMARY KEY (Id));
--- Creacion tabla Renta ---
CREATE TABLE Renta (
  Numero      INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, 
  PeriodoId   INTEGER NOT NULL, 
  ParametroId INTEGER, 
  PRIMARY KEY (Numero));

--========================================================================================================
--                                        Alteraciones de tablas                                        --
--========================================================================================================
ALTER TABLE Linea ADD CONSTRAINT asociado FOREIGN KEY (CarroId) REFERENCES Carro (Id);
ALTER TABLE Linea ADD CONSTRAINT contiene FOREIGN KEY (Rentanumero) REFERENCES Renta (Numero);
ALTER TABLE BilletesXRenta ADD CONSTRAINT pertenece FOREIGN KEY (BilleteId) REFERENCES Billete (Id);
ALTER TABLE Renta ADD CONSTRAINT posee FOREIGN KEY (ParametroId) REFERENCES Parametro (Id);
ALTER TABLE BilletesXRenta ADD CONSTRAINT "se paga" FOREIGN KEY (Rentanumero) REFERENCES Renta (Numero);
ALTER TABLE Renta ADD CONSTRAINT tiene FOREIGN KEY (PeriodoId) REFERENCES Periodo (Id);

--========================================================================================================
--                                         Insercion de tuplas                                          --
--========================================================================================================
----NOMBRE TALA----