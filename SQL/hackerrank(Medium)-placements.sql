select name 
from 
friends natural join packages as s
natural join students
join packages fs on Friend_id = fs.id
where fs.salary > s.salary
order by fs.salary
