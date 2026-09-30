# Write your MySQL query statement below
SELECT Department , Employee , Salary
FROM (
    SELECT 
            d.name as Department ,
            e.name as Employee , 
            e.salary AS Salary ,
            DENSE_RANK() OVER (
                PARTITION BY e.departmentID
                ORDER BY e.salary DESC
            ) as spot
            FROM Employee e
            JOIN Department d on e.departmentID = d.id
) t
WHERE spot <= 3