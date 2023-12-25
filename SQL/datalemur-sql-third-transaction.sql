select user_id, transaction_date, spend from (
select user_id, transaction_date, spend, row_number() over(PARTITION BY user_id ORDER BY transaction_date)as transaction_order
from transactions) as t
where transaction_order = 3; 
