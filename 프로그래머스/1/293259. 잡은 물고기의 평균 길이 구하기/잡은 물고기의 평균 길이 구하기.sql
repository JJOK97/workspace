-- 코드를 작성해주세요
SELECT ROUND(AVG(IFNULL(IF(length < 10, 10, length), 10)),2 ) AS average_length
FROM FISH_INFO