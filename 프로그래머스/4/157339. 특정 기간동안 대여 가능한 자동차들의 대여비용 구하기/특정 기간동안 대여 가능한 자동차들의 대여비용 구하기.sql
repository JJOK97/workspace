SELECT 
    A.CAR_ID
  , A.CAR_TYPE
  , A.FEE
FROM 
(
    SELECT 
        C.CAR_ID
      , C.CAR_TYPE
      , ROUND(C.DAILY_FEE * 30 * (1 - DP.DISCOUNT_RATE/100)) AS FEE
    FROM CAR_RENTAL_COMPANY_CAR C
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP
      ON C.CAR_TYPE = DP.CAR_TYPE
     AND DP.DURATION_TYPE = '30일 이상'
    WHERE C.CAR_TYPE IN ('세단','SUV')
      -- NOT EXISTS: 11월 중 겹치는 대여 이력이 "없는" 차만
      AND NOT EXISTS (
           SELECT 1
           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
           WHERE H.CAR_ID = C.CAR_ID
             AND H.START_DATE <= DATE '2022-11-30'
             AND H.END_DATE   >= DATE '2022-11-01'
      )
) A
WHERE A.FEE >= 500000
  AND A.FEE <  2000000
ORDER BY 
    A.FEE DESC
  , A.CAR_TYPE ASC
  , A.CAR_ID DESC;
