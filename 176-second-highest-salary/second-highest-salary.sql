# Write your MySQL query statement below
SELECT MAX(salary) AS SecondHighestSalary
FROM (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1, 1
) AS t; #MAX() of no values returns NULL.