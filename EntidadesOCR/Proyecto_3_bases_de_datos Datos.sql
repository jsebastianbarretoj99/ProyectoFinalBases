SELECT Id, Cantidad, Denominacion 
  FROM Billete;
SELECT Rentanumero, BilleteId, Cantidad 
  FROM BilletesXRenta;
SELECT Id, Placa, UnidadesDisponibles, Precio, Puestos 
  FROM Carro;
SELECT Numero, Rentanumero, CarroId, Cantidad 
  FROM Linea;
SELECT Id, Valor, TasaCarros 
  FROM Parametro;
SELECT Id, Fecha 
  FROM Periodo;
SELECT Numero, PeriodoId, ParametroId 
  FROM Renta;


INSERT INTO Billete
  (Id, 
  Cantidad, 
  Denominacion) 
VALUES 
  (?, 
  ?, 
  ?);
INSERT INTO BilletesXRenta
  (Rentanumero, 
  BilleteId, 
  Cantidad) 
VALUES 
  (?, 
  ?, 
  ?);
INSERT INTO Carro
  (Id, 
  Placa, 
  UnidadesDisponibles, 
  Precio, 
  Puestos) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO Linea
  (Numero, 
  Rentanumero, 
  CarroId, 
  Cantidad) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?);
INSERT INTO Parametro
  (Id, 
  Valor, 
  TasaCarros) 
VALUES 
  (?, 
  ?, 
  ?);
INSERT INTO Periodo
  (Id, 
  Fecha) 
VALUES 
  (?, 
  ?);
INSERT INTO Renta
  (Numero, 
  PeriodoId, 
  ParametroId) 
VALUES 
  (?, 
  ?, 
  ?);


UPDATE Billete SET 
  Cantidad = ?, 
  Denominacion = ? 
WHERE
  Id = ?;
UPDATE BilletesXRenta SET 
  Cantidad = ? 
WHERE
  Rentanumero = ? AND BilleteId = ?;
UPDATE Carro SET 
  Placa = ?, 
  UnidadesDisponibles = ?, 
  Precio = ?, 
  Puestos = ? 
WHERE
  Id = ?;
UPDATE Linea SET 
  CarroId = ?, 
  Cantidad = ? 
WHERE
  Numero = ? AND Rentanumero = ?;
UPDATE Parametro SET 
  Valor = ?, 
  TasaCarros = ? 
WHERE
  Id = ?;
UPDATE Periodo SET 
  Fecha = ? 
WHERE
  Id = ?;
UPDATE Renta SET 
  PeriodoId = ?, 
  ParametroId = ? 
WHERE
  Numero = ?;


DELETE FROM Billete 
  WHERE Id = ?;
DELETE FROM BilletesXRenta 
  WHERE Rentanumero = ? AND BilleteId = ?;
DELETE FROM Carro 
  WHERE Id = ?;
DELETE FROM Linea 
  WHERE Numero = ? AND Rentanumero = ?;
DELETE FROM Parametro 
  WHERE Id = ?;
DELETE FROM Periodo 
  WHERE Id = ?;
DELETE FROM Renta 
  WHERE Numero = ?;

