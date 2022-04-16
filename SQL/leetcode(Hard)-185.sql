select Department, Employee, Salary
from
(
select department.name Department, employee.name Employee, Salary, dense_rank() over w as dr
from employee join department on departmentId = department.id 
window w as (partition by departmentId order by salary desc)

) temp
where dr <=3
