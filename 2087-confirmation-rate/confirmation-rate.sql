SELECT s.user_id,
       IFNULL(ROUND(second.totalconfirmed / first.totalcall, 2), 0.00) AS confirmation_rate
FROM Signups s
LEFT JOIN (
    -- total calls per user
    SELECT user_id, COUNT(*) AS totalcall
    FROM Confirmations
    GROUP BY user_id
) AS first
ON s.user_id = first.user_id
LEFT JOIN (
    -- confirmed calls per user
    SELECT user_id, COUNT(*) AS totalconfirmed
    FROM Confirmations
    WHERE action = 'confirmed'
    GROUP BY user_id
) AS second
ON s.user_id = second.user_id;
