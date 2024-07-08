-- 코드를 작성해주세요
select count(*) FISH_COUNT
from fish_info
where length IS NULL OR LENGTH < 10