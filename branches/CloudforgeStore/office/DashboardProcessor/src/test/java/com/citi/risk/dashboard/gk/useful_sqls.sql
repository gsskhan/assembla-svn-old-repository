

-- For getting threshold table data
select threshold_master_id
      ,apps_id
      ,kpi_category_name
      ,kpi_name
      ,component
      ,kpi_threashold_value
      ,kpi_threadhold_color_code
      ,last_update
      ,last_updatedby
from ets_dshbd_kpi_threshold_master
where apps_id = 1 					--<< Input Application ID here 
order by kpi_category_name, kpi_name,component, kpi_threashold_value asc;