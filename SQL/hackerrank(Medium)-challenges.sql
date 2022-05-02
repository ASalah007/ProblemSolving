select hacker_id, name, count(*) as c
from hackers natural join challenges
group by hacker_id, name
having c in
(
    select *
    from
    (
    select count(*) as cc
    from Challenges
    group by hacker_id 
    ) as t 
    group by cc
    having count(*) = 1 
union 
    select max(cc) from
    (
    select count(*) as cc
    from Challenges
    group by hacker_id 
    ) as t2
)
order by c desc, hacker_id

