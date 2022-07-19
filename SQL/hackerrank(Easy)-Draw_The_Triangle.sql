-- with recursive 
-- triangle(x) as (select repeat("* ", 20) union all select substring(x from 3) from triangle where char_length(x) > 2)
-- select * from triangle
-- order by x;

with recursive
t(x) as (select 1 union all select x+1 from t where x < 20)
select repeat("* ", t.x) from t;

