create table Ataque(
	id_at varchar(10) not null,
	nombre varchar(80),
	muertes int,
	heridos int,
	pais varchar(80),
	constraint pk_TAtaque primary key(id_at)
);

create table Tip_Ataque(
	id_at varchar(10) not null,
	nom_tipo varchar(80),
	reg_afect varchar(80),
	mutant_afect varchar(255),
	grupo_at varchar(255),
	alien varchar(255),
	bienes varchar(255)
);

create table Armamento(
	id_ceo varchar(10),
	tipo varchar(80),
	cantidad int,
	id_h int
);

create table STARK(
	id_ceo varchar(10) not null,
	nombre varchar(80),
	constraint pk_STARK primary key(id_ceo)
);

create table Heroes(
	id_h int not null,
	nombre varchar(80),
	id_l int,
	id_sub varchar(10),
	constraint pk_Heroes primary key(id_h)
);

create table Integrantes(
	id_h int,
	nombre varchar(80)
);

create table Lider(
	id_l int not null,
	nombre varchar(80),
	equipo_arm varchar(255),
	constraint pk_Lider primary key(id_l)
);

create table Reuniones(
	id_l int,
	tema varchar(80),
	hora varchar(10)
);

create table subdivision(
	id_sub varchar(10) not null,
	nombre varchar(80),
	constraint pk_Subdiv primary key(id_sub)
);

create table Lideres_subdivision(
	id_ls varchar(10) not null,
	nombre varchar(80),
	rango varchar(25),
	id_sub varchar(10),
	constraint pk_Lid primary key(id_ls)
);

create table Agentes(
	id_agent int not null,
	nombre varchar(80),
	especializacion varchar(25),
	puesto varchar(30),
	constraint pk_Agent primary key(id_agent)
);

create table Involucrados(
	id_at varchar(10),
	id_h int,
	id_agent int,
	fecha varchar(80)
);

create table Users(
	id_us varchar(10) not null,
	nom_us varchar(80),
	pass varchar(6),
	roll varchar(80),
	constraint pk_users primary key(id_us)
);