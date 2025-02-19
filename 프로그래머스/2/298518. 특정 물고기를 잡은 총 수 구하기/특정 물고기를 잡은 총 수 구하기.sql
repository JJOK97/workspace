-- 코드를 작성해주세요
select count(*) fish_count
from fish_info join fish_name_info on fish_info.fish_type = fish_name_info.fish_type
where fish_name_info.fish_name in ("BASS", "SNAPPER");