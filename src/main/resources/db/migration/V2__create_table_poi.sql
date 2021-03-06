drop table if exists point_of_interest cascade;
create table point_of_interest (id int8 generated by default as identity, altitude float4, create_date timestamp not null, latitude float4, longitude float4, name varchar(255) not null, type int4 not null, update_date timestamp not null, country_id int8 not null, primary key (id));
alter table if exists point_of_interest add constraint UK_g8pjhdyy7nnw96xjma8vb0sym unique (name);
alter table if exists point_of_interest add constraint FK66sofnsyvr1g5icrfoj9ypno4 foreign key (country_id) references country;
