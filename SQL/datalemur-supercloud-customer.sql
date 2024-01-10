select customer_id
from customer_contracts as c join products as p on c.product_id = p.product_id
group by customer_id
having count(distinct product_category) = (select count(DISTINCT product_category) categories_count from products)
