-- diaryTable���� ���� �������� �Էµ� �� ���� 10�� ������ ��ȸ.
-- (��ȣ, ����, �ۼ���, �̺�Ʈ��, �Է��� - ��ȸ�÷�)

select num, subject, writer, e_year, e_month, e_day, w_date
from (
			select rownum r, num, subject, writer, e_year, e_month, e_day, w_date
			from (select num, subject, writer, e_year, e_month, e_day, w_date
			           from diary
			           order by num desc
						)
          )
where r between 1 and 10;

