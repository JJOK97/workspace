WITH AvailableCars AS (
    SELECT 
        CAR.CAR_ID, 
        CAR.CAR_TYPE, 
        CAR.DAILY_FEE, 
        NVL(PLAN.DISCOUNT_RATE, 0) AS DISCOUNT_RATE
    FROM 
        CAR_RENTAL_COMPANY_CAR CAR
    LEFT JOIN 
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN PLAN
    ON 
        CAR.CAR_TYPE = PLAN.CAR_TYPE AND PLAN.DURATION_TYPE = '30일 이상'
    WHERE 
        CAR.CAR_TYPE IN ('세단', 'SUV')
),
FilteredRentalHistory AS (
    SELECT 
        CAR_ID
    FROM 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        START_DATE <= DATE '2022-11-30' AND END_DATE >= DATE '2022-11-01'
    GROUP BY 
        CAR_ID
),
FilteredCars AS (
    SELECT 
        A.CAR_ID, 
        A.CAR_TYPE, 
        A.DAILY_FEE, 
        A.DISCOUNT_RATE,
        (A.DAILY_FEE * 30 * (1 - A.DISCOUNT_RATE / 100)) AS FEE
    FROM 
        AvailableCars A
    LEFT JOIN 
        FilteredRentalHistory R
    ON 
        A.CAR_ID = R.CAR_ID
    WHERE 
        R.CAR_ID IS NULL
      AND 
        (A.DAILY_FEE * 30 * (1 - A.DISCOUNT_RATE / 100)) BETWEEN 500000 AND 2000000
)
SELECT 
    CAR_ID, 
    CAR_TYPE, 
    FEE
FROM 
    FilteredCars
ORDER BY 
    FEE DESC, 
    CAR_TYPE ASC, 
    CAR_ID DESC;
