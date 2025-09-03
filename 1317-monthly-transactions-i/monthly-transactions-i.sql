select Date_FORMAT(trans_date,"%Y-%m") as month,country, 
count(id) as  trans_count ,
count(CASE WHEN  state='approved' then 1 END)  AS approved_count  ,sum(amount) as trans_total_amount ,sum(case when state='approved' then amount Else 0 END) as approved_total_amount 
from Transactions
group by month ,country