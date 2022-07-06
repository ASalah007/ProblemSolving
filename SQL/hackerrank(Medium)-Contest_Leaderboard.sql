select hacker_id, name, sum(uq_score) as score
from hackers natural join (
    select hacker_id, max(score) as uq_score
    from submissions 
    group by hacker_id, challenge_id
) as uq_scores
group by hacker_id, name
having score > 0
order by score desc, hacker_id;
