SELECT 
	*
FROM 
	simi.simiproduct_data_product AS dp 
	LEFT JOIN simi.simiproduct_data_product_pub_scope AS ps 
	ON dp.pub_scope_id = ps.id 
	--LEFT JOIN simi.simidata_data_set_view AS dsw 
	--ON dsw.id = dp.id
	--LEFT JOIN simi.simiiam_permission AS perm 
	--ON perm.data_set_view_id = dsw.id
	--LEFT JOIN simi.simiiam_role AS r 
	--ON perm.role_id = r.id
	
WHERE 
	ps.display_text IN ('WGC, QGIS u. WMS', 'Nur WMS', 'WGC u. QGIS', /*'Nicht (selbst) publiziert'*/)
	AND 
	dtype NOT IN ('simiProduct_Map')
;