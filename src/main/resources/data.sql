insert into category(category) values('DATA')
insert into category(category) values('LOGISTICS')
insert into category(category) values('IDENTITY VALIDATION')
insert into category(category) values('FIDELIZATION')
insert into category(category) values('PAYMENTS')

insert into question(question,fk_category) values ('How big is your company?',2)
insert into question(question,fk_category) values ('How many users you have?',1)

insert into client(email) values ('test')

insert into answer(fk_client,fk_question,points) values (1,1,100)
insert into answer(fk_client,fk_question,points) values (1,2,1000)