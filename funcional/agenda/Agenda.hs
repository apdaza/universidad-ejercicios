module Agenda where

type Nombre = String 
type Telefono = String
type Contacto = (Nombre, Telefono)
type Contactos = [Contacto]

buscar::Contactos->Nombre->Telefono
buscar [] nombre = "No"
buscar ((n, t):cs) nombre 
    | n == nombre = t
    | otherwise = buscar cs nombre

insertar::Contactos->Contacto->Contactos
insertar lista contacto = contacto : lista

mis_contactos::Contactos
mis_contactos = [("Juan","123"),("Maria","456"),("Pedro","987")]