create table user_card
(
  id serial not null
    constraint user_card_pkey
    primary key,
  first_name varchar(50) default 'DefaultFirstName'::character varying not null,
  last_name varchar(80) default 'DefaultLastName'::character varying not null,
  password varchar(80) not null,
  email varchar(100) not null
    constraint uk_9vo0r76325y30g44ol4s0t6sq
    unique,
  date_of_birth timestamp default now(),
  address_id varchar(30),
  avatar_url varchar(100) default 'http://example-avatar-url.elect.com'::character varying,
  gender varchar(10) default 'Male'::character varying,
  phone varchar(20) default '+77-777-7777-777'::character varying,
  registered_on timestamp default now(),
  skype varchar(30) default 'skype-example'::character varying
)
;