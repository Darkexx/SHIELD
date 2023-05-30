alter table tip_ataque
add foreign key (id_at) references ataque(id_at) on delete cascade;

alter table armamento
add foreign key (id_ceo) references stark(id_ceo);

alter table involucrados
add foreign key (id_at) references ataque(id_at),
add foreign key (id_h) references heroes(id_h),
add foreign key (id_agent) references agentes(id_agent);

alter table integrantes
add foreign key (id_h) references heroes(id_h);

alter table heroes
add foreign key (id_l) references lider(id_l),
add foreign key (id_sub) references subdivision(id_sub);

alter table reuniones
add foreign key (id_l) references lider(id_l);

alter table lideres_subdivision
add foreign key (id_sub) references subdivision(id_sub);