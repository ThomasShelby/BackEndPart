INSERT INTO public.address (id, city, country, street_name, street_number)
VALUES (1, 'Lviv', 'Ukraine', 'Street', '25');

INSERT INTO public.user_card (id, avatar_url, date_of_birth, email, first_name, gender, last_name, password, phone, registered_on, skype, address_id)
VALUES (1, 'http://example-avatar-url.elect.com', '2017-07-27 10:32:58.556846', 'edwffwf', 'DefaultFirstName', 'Male', 'DefaultLastName', 'wfefw', '+77-777-7777-777', '2017-07-27 10:32:58.556846', 'skype-example', 1);

INSERT INTO public.product (id, description, image_name, image_url, isfamous, name, price, registered_on, user_id)
VALUES (1, 'description', 'imagename', 'ntbgbge', true, 'name', 0, '2017-07-27 10:46:59.357386', 1);
