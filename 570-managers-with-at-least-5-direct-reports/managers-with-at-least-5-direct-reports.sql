SELECT a.name
FROM Employee a 
JOIN Employee b ON a.id = b.managerId
group by  b.managerID having count(*)>=5
