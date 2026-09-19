SELECT
    q1.query_name,

    ROUND(AVG(q1.rating / q1.position), 2) AS quality,

    ROUND(
        SUM(CASE
                WHEN q1.rating < 3 THEN 1
                ELSE 0
            END) * 100.0 / COUNT(q1.rating),
        2
    ) AS poor_query_percentage

FROM Queries q1
GROUP BY q1.query_name;