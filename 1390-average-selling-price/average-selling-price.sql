# Write your MySQL query statement below
select P.product_id ,IFNULL(ROUND(sum(units*price)/sum(units),2),0) 
AS average_price from
Prices P left join UnitsSold U
on P.product_id = U.product_id
and purchase_date>=start_date  and end_date>=purchase_date
group by P.product_id 

