# Write your MySQL query statement below
/*
ALL ORDERS
     ↓
Find FIRST order for each customer
     ↓
Check if first order was IMMEDIATE
     ↓
Count immediate first orders
     ↓
Divide by total first orders
     ↓
× 100
*/
SELECT
    ROUND(
        SUM(
            CASE
                WHEN d.order_date = d.customer_pref_delivery_date
                THEN 1
                ELSE 0
            END
        ) * 100.0 / COUNT(*),
        2
    ) AS immediate_percentage
FROM Delivery d
JOIN (
    SELECT
        customer_id,
        MIN(order_date) AS first_order_date
    FROM Delivery
    GROUP BY customer_id
) f
    ON d.customer_id = f.customer_id
    AND d.order_date = f.first_order_date;