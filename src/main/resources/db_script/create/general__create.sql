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

create table product
(
  id serial not null
    constraint product_pkey
    primary key,
  description varchar(500),
  image_name varchar(80) not null,
  image_url varchar(80),
  isfamous boolean not null
    constraint uk_9fiwxvi8laxee1880lrfc1lht
    unique,
  name varchar(50) not null,
  price double precision,
  registered_on timestamp default now(),
  user_id integer not null
)
;

create table user_card
(
  id serial not null
    constraint user_card_pkey
    primary key,
  avatar_url varchar(100) default 'http://example-avatar-url.elect.com'::character varying,
  date_of_birth timestamp default now(),
  email varchar(100) not null
    constraint uk_9vo0r76325y30g44ol4s0t6sq
    unique,
  first_name varchar(50) default 'DefaultFirstName'::character varying not null,
  gender varchar(10) default 'Male'::character varying,
  last_name varchar(80) default 'DefaultLastName'::character varying not null,
  password varchar(80) not null,
  phone varchar(20) default '+77-777-7777-777'::character varying,
  registered_on timestamp default now(),
  skype varchar(30) default 'skype-example'::character varying,
  address_id integer
    constraint fk_lrdaf69sq99t3f31c63e92lhw
    references address
)
;

alter table product
  add constraint fk_miislg5rujgruv45l3hv00cn2
foreign key (user_id) references user_card
;