# Write your MySQL query statement below
select customer_id ,count(customer_id) as count_no_trans
from  (select v.customer_id, v.visit_id,T.transaction_id
from Visits v left join Transactions T  on v.visit_id=T.visit_id)  as temp
where  temp.transaction_id is null
group by customer_id;

