
alter table test_like add img varchar2(255);

select * from test_like;

update test_like
set img='default.png'
where img is null;
