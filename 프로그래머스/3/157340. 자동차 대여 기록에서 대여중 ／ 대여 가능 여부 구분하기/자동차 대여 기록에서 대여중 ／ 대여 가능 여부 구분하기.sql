-- 코드를 입력하세요
SELECT DISTINCT car_id,
    CASE 
        WHEN car_id IN (
            SELECT car_id
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE TO_CHAR(start_date, 'yyyy-mm-dd') <= '2022-10-16' 
              AND TO_CHAR(end_date, 'yyyy-mm-dd') >= '2022-10-16'
        ) THEN '대여중' 
        ELSE '대여 가능' 
    END AS availability
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
ORDER BY 
    car_id DESC;
