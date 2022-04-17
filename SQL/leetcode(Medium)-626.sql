select id,
if(id%2=0, 
		lag(student)over w,
		ifnull(lead(student)over w, student)
    ) student
from seat
window w as (order by id);
