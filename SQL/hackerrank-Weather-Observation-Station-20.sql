select round(avg(lat_n), 4)
from(
select lat_n, row_number() over(order by lat_n) as rn, count(*) over() as c
from station
) t
where rn = floor(c/2)+1 or rn = floor(c/2)+mod(c,2)
