insert into ataque(id_at,nombre,muertes,heridos,pais) values
	('siminv19','Invasion Simbionte 2019',400,650,'Estados unidos(NY)'),
	('hydra21','Renace hydra(otra vez)',650,1500,'Alemania');
	
insert into tip_ataque(id_at,nom_tipo,reg_afect,mutant_afect,grupo_at,alien,bienes) values
	('hydra21','Invasion territorial','Gran parte de alemania','','hydra','',''),
	('siminv19','Amenaza extraterrestre','Estados unidos','','','Simbiontes','');

insert into stark(id_ceo,nombre) values
	('RichG','Richard Guerrero'),
	('MilMo','Miles Morrigan');

insert into armamento(id_ceo,tipo,cantidad,id_h) values
	('RichG','Armas de Adamantio',25,20),
	('MilMo','Misiles balisticos',20,21);
	
insert into lider(id_l,nombre,equipo_arm) values
	(101,'Charles Xavier','Ordenadores potentes'),
	(102,'Tony Stark','Armas balisticas'),
	(103,'Rocket Racoon','Armas variadas');

insert into subdivision(id_sub,nombre) values
	('SHIELD','Strategic Homeland Intervention, Enforcement and Logistics Division'),
	('DODC','The United States Department of Damage Control'),
	('N','Sin subdivision');
	
insert into heroes(id_h,nombre,id_l,id_sub) values
	(20,'X-men',101,'DODC'),
	(21,'Avengers',102,'SHIELD'),
	(22,'Guardians of the galaxy',103,'N');
	
insert into integrantes(nombre,id_h) values
	('Tony Stark',21),
	('Bruce Banner',21),
	('Natasha Romanoff',21),
	('Scott Summers',20),
	('Peter Quill',22),
	('Gamora Zen',22),
	('Rocket Racoon',22);

insert into reuniones(id_l,tema,hora) values
	(101,'Sismtema educativo mutante','07:00'),
	(102,'Posibles escenarios apocalipticos','14:00');

insert into lideres_subdivision(id_ls,nombre,rango,id_sub) values
	('niF','nick fury','capitan','SHIELD'),
	('gOrw','George Orwll','capitan','DODC');

insert into agentes(id_agent,nombre,especializacion,puesto) values
	(40,'Phil Coulson','Estratega','Ayudante avenger'),
	(41,'Quake','Combate','guardaespaldas');

insert into involucrados(id_at,id_h,id_agent,fecha) values
	('siminv19',21,40,'20/03/2019');