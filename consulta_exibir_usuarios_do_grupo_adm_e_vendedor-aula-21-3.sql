select *
	from usuario u
	 left outer join usuario_grupo ug on u.codigo = ug.codigo_usuario
     left outer join grupo g on ug.codigo_grupo = g.codigo
		where (
			u.codigo in (select codigo_usuario from usuario_grupo where codigo_grupo = 1)
        and u.codigo in (select codigo_usuario from usuario_grupo where codigo_grupo = 2))      