create table union_test as
(select empno, ename, job, sal, hiredate, deptno from emp);
alter table union_test add retired char(1);

select * from union_test;

update union_test
set retired='y'
where to_char(hiredate, 'yyyymm') between '198102' and '198110';

update union_test
set retired='n'
where not (to_char(hiredate, 'yyyymm') between '198102' and '198110');

commit;

SELECT  EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO, RETIRED
FROM UNION_TEST
WHERE RETIRED='n';
