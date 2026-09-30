# Write your MySQL query statement below
SELECT id , COUNT(*) AS num
FROM (
    SELECT requester_id as id from RequestAccepted
    UNION ALL
    SELECT accepter_id as id from RequestAccepted
) t
GROUP BY id
ORDER BY num DESC
LIMIT 1;