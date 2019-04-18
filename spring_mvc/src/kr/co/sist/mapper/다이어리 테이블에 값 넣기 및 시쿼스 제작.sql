select * from DIARY;

-- 시퀀스 만들기.
create sequence seq_reply
increment by 1
start with 1
maxvalue 999999999;

insert into diary_reply(num, num_ref, writer, content, input_date)
values(seq_reply.nextval, 61, '노진경', '사랑과 정의의 이름으로 널 용서하지 않겠다!!', sysdate);

insert into diary_reply(num, num_ref, writer, content, input_date)
values(seq_reply.nextval, 61, '기미철', '사랑과 정의의 이름으로 널 용서하지 않겠다!!', sysdate);

commit;
