select * from DIARY;

-- ������ �����.
create sequence seq_reply
increment by 1
start with 1
maxvalue 999999999;

insert into diary_reply(num, num_ref, writer, content, input_date)
values(seq_reply.nextval, 61, '������', '����� ������ �̸����� �� �뼭���� �ʰڴ�!!', sysdate);

insert into diary_reply(num, num_ref, writer, content, input_date)
values(seq_reply.nextval, 61, '���ö', '����� ������ �̸����� �� �뼭���� �ʰڴ�!!', sysdate);

commit;
