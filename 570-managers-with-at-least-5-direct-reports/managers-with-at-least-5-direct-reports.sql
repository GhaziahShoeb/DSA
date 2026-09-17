# Write your MySQL query statement below

SELECT  m.name
FROM Employee m
INNER JOIN Employee b 
ON m.id = b.managerID
GROUP BY m.id , m.name
HAVING COUNT(*) >= 5;