select patient_id, patient_name, conditions
from patients
where conditions Regexp '^DIAB1.*'
or conditions like '% DIAB1%';
