select artist_name, rank as artist_rank 
from (
  SELECT artist_id, dense_rank() over w as rank 
  from ( 
    SELECT artist_id, count(*) as cnt
    from 
      global_song_rank g join songs s on s.song_id = g.song_id 
    where rank <= 10
    group by artist_id
  ) as t
  window w as (order by cnt)
) as tt join artists on artists.artist_id = tt.artist_id 
where rank < 5
order by artist_rank
