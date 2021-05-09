select u.email usuario
	,group_concat(substring(p.nome, 6) order by p.nome separator ', ') permissao
 from usuario u
	, usuario_grupo ug
    , grupo g
    , grupo_permissao gp
    , permissao p
 where ug.codigo_usuario = u.codigo
	and ug.codigo_grupo = g.codigo
    and g.codigo = gp.codigo_grupo
    and gp.codigo_permissao = p.codigo
 group by usuario