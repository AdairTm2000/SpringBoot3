ALTER TABLE vollmed_api.medicos ADD activo TINYINT;
UPDATE vollmed_api.medicos SET activo = 1;