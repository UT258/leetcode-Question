# Write your MySQL query statement below
select  person.firstName ,person.lastName ,Address.city,Address.state
from Person left join Address on  Person.personId=Address.personId
