-- 음식종류별로 즐겨찾기수가 가장 많은 식당
-- 음식 종류 기준으로 내림차순

SELECT RI.FOOD_TYPE
    , RI.REST_ID
    , RI.REST_NAME
    , RI.FAVORITES
FROM REST_INFO RI
JOIN (
    SELECT FOOD_TYPE
        , MAX(FAVORITES) AS MAX_FAVO
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) SRI ON RI.FOOD_TYPE = SRI.FOOD_TYPE
WHERE RI.FAVORITES = SRI.MAX_FAVO
ORDER BY FOOD_TYPE DESC;