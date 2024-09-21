-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE (NAME LIKE '%el%' or name Like '%El%')
    and animal_type = 'Dog'
order by name
