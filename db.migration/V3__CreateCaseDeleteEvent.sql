drop table Event;

create table Action (
                        id bigserial primary key,
                        date DATE not null,
                        habit_id bigserial not null REFERENCES Habit(id)
);
