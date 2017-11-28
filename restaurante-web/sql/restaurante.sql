delete from ClienteEntity;
delete from DomicilioEntity;
delete from MesaEntity;
delete from PagoEntity;
delete from PedidoEntity   ;
delete from Reserva;
delete from restauranteEntity;
delete from SucursalEntity;
delete from TarjetaPuntosEntity;


insert into ClinteEntity (id, tieneTarjeta, nombre, apellido) values ( 1, TRUE, 'Cliente1', 'Apellido1');
insert into ClienteEntity (id, tieneTarjeta, nombre, apellido) values ( 2, TRUE, 'Cliente2', 'Apellido2');
insert into ClienteEntity (id, tieneTarjeta, nombre, apellido) values ( 3, FALSE, 'Cliente3', 'Apellido3');
insert into ClienteEntity (id, tieneTarjeta, nombre, apellido) values ( 4, TRUE, 'Cliente4', 'Apellido4');

insert into DomicilioEntity (id, rango) values (1, 15);
insert into DomicilioEntity (id, rango) values (2, 10);
insert into DomicilioEntity (id, rango) values (3, 9);
insert into DomicilioEntity (id, rango) values (4, 18);

insert into MesaEntity (id, sillasDisponibles, piso, disponible) values (1, 4, 2, TRUE);
insert into MesaEntity (id, sillasDisponibles, piso, disponible) values (2, 2, 1, FALSE);
insert into MesaEntity (id, sillasDisponibles, piso, disponible) values (3, 2, 2, FALSE
insert into MesaEntity (id, sillasDisponibles, piso, disponible) values (4, 4, 1, TRUE);

insert into PagoEntity (id, registrado, pagoAnticipado, tipo) values (1, TRUE, TRUE, 'DEBITO');
insert into PagoEntity (id, registrado, pagoAnticipado, tipo) values (2, TRUE, FALSE,'CREDITO');
insert into PagoEntity (id, registrado, pagoAnticipado, tipo) values (3, FLASE, TRUE,'EFECTIVO');
insert into PagoEntity (id, registrado, pagoAnticipado, tipo) values (4, FALSE, FALSE,'DEBITO');

insert into PedidoEntity (id, fecha, direccion) values (1, 25-09-2017, 'calle 1 numero 2');
insert into PedidoEntity (id, fecha, direccion) values (2, 24-09-2017, 'calle 2 numero 4');
insert into PedidoEntity (id, fecha, direccion) values (3, 30-09-2017, 'calle 1 numero 2');
insert into PedidoEntity (id, fecha, direccion) values (4, 25-09-2017, 'calle 3 numero 5');

insert into PlatoEntity (id, tipo, especialSucursal, precio) values (1, 'SOPA', TRUE, 10);
insert into PlatoEntity (id, tipo, especialSucursal, precio) values (2, 'SECO', FLASE, 11);
insert into PlatoEntity (id, tipo, especialSucursal, precio) values (3, 'POSTRE', TRUE, 8);
insert into PlatoEntity (id, tipo, especialSucursal, precio) values (4, 'SOPA', TRUE, 5);

insert into ReservaEntity (id, fecha) values (1, 01-10-2017);
insert into ReservaEntity (id, fecha) values (2, 02-10-2017);
insert into ReservaEntity (id, fecha) values (3, 03-10-2017);
insert into ReservaEntity (id, fecha) values (4, 04-10-2017);

insert into RestauranteEntity (id, hora_inicio_maniana, hora_inicio_tarde, hora_fin_maniana, hora_fin_tarde) values (1, 08:30, 14:30, 14:00, 19:00);
insert into RestauranteEntity (id, hora_inicio_maniana, hora_inicio_tarde, hora_fin_maniana, hora_fin_tarde) values (2, 08:30, 14:30, 14:00, 19:00);
insert into RestauranteEntity (id, hora_inicio_maniana, hora_inicio_tarde, hora_fin_maniana, hora_fin_tarde) values (3, 08:30, 14:30, 14:00, 19:00);
insert into RestauranteEntity (id, hora_inicio_maniana, hora_inicio_tarde, hora_fin_maniana, hora_fin_tarde) values (4, 06:30, 15:30, 15:00, 20:00);

insert into SucursalEntity (id, calificacion, dosPisos, direccion) values (1, '5 estrellas', TRUE, 'calle 4 numero 10');
insert into SucursalEntity (id, calificacion, dosPisos, direccion) values (2, '4 estrellas', TRUE, 'calle 2 numero 8');
insert into SucursalEntity (id, calificacion, dosPisos, direccion) values (3, '4 estrellas', FALSE, 'calle 3 numero 9');
insert into SucursalEntity (id, calificacion, dosPisos, direccion) values (4, '5 estrellas', TRUE, 'calle 1 numero 7');

insert into TarjetaPuntosEntity (id, puntos, vencimientos) values (1, 3, <01-01-2018, 02-01-2018, 03-01-2018>);
insert into TarjetaPuntosEntity (id, puntos, vencimientos) values (2, 3, <01-01-2018, 02-01-2018, 03-01-2018>);
insert into TarjetaPuntosEntity (id, puntos, vencimientos) values (3, 1, <01-01-2018>);
insert into TarjetaPuntosEntity (id, puntos, vencimientos) values (4, 0, <>);

