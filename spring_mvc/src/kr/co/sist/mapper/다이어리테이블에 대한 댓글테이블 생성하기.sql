create table diary_reply(
	num number,
	num_ref number,
	writer varchar2(30),
	content varchar2(600),
	input_date date,
	constraint pk_diary_reply primary key(num),
	constraint fk_num_ref foreign key(num_ref) references diary(num)
);
