-- diaryTable에서 가장 마지막에 입력된 글 부터 10건 까지를 조회.
-- (번호, 제목, 작성자, 이벤트일, 입력일 - 조회컬럼)

select num, subject, writer, e_year, e_month, e_day, w_date
from (
			select rownum r, num, subject, writer, e_year, e_month, e_day, w_date
			from (select num, subject, writer, e_year, e_month, e_day, w_date
			           from diary
			           order by num desc
						)
          )
where r between 1 and 10;

