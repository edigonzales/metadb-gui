SELECT 
	/*
	dp.*,
	ps.display_text,
	dsw.*,
	sa.*,
	perm.*,
	r.*
	*/
 	dp.id,
 	dp.dtype,
 	dp.description,
 	dp.remarks,
 	dp.title,
 	dp.ident_part,
 	dp.derived_identifier,
 	dp.keywords,
	dp.synonyms,
	ps.display_text,
	dsw.style_server,
	dsw.service_download,
	sa.transparency,
	json_agg(r."name") FILTER (WHERE r."name" IS NOT NULL)
	--r."name",
	--tv.*,
	--pgt.*
FROM 
	simi.simiproduct_data_product AS dp 
	LEFT JOIN simi.simiproduct_data_product_pub_scope AS ps 
	ON dp.pub_scope_id = ps.id 
	LEFT JOIN simi.simidata_data_set_view AS dsw 
	ON dsw.id = dp.id
	LEFT JOIN simi.simiproduct_single_actor AS sa -- für Transparenz 
	ON sa.id = dp.id
	LEFT JOIN simi.simiiam_permission AS perm  -- für permissions
	ON perm.data_set_view_id = dsw.id
	LEFT JOIN simi.simiiam_role AS r 
	ON perm.role_id = r.id
	--LEFT JOIN simi.simidata_table_view AS tv -- Da zu unterschiedlich (Raster, external WMS etc. erst später on-demand requesten.)
	--ON tv.id = dp.id 
	--LEFT JOIN simi.simi.simidata_postgres_table AS pgt 
	--ON tv.postgres_table_id = pgt.id 
	
WHERE 
	ps.display_text IN ('WGC, QGIS u. WMS', 'Nur WMS', 'WGC u. QGIS'/*, 'Nicht (selbst) publiziert'*/)
	AND 
	dtype NOT IN ('simiProduct_Map', 'simiProduct_ExternalWmsLayers') 
	--dtype = 'simiData_TableView' -- test
GROUP BY 
	1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
ORDER BY
	 dp.ident_part
	
;




/*
 * Falls keine style_server und service_download==true -> gibt es das Produkt nur im Dataservice
 */ 
