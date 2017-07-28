create table address
(
  id serial not null
    constraint address_pkey
    primary key,
  city varchar(50) default 'DefaultCity'::character varying not null,
  country varchar(50) default 'DefaultCountry'::character varying not null,
  street_name varchar(50) default 'DefaultStreetName'::character varying not null,
  street_number varchar(10) default 'DefaultStreetNumber'::character varying not null
)
;