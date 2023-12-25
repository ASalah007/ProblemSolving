select 
  user_id, 
  tweet_date, 
  round ((cast(tweet_count as decimal(10,2)) + COALESCE(tweet_count2, 0) + COALESCE(tweet_count3, 0)) /(1 + COALESCE(tweet_count2/tweet_count2, 0) + COALESCE(tweet_count3/tweet_count3, 0) ), 2) as rolling_avg_3d
from (
select user_id, tweet_count, tweet_date, lag(tweet_count, 1) over(w)  as tweet_count2 , 
lag(tweet_count, 2) over w as tweet_count3

from tweets 
window w as (PARTITION BY user_id order by tweet_date)
) as t
