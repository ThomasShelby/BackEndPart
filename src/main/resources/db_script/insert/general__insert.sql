INSERT INTO public.address (id, city, country, street_name, street_number)
VALUES (1, 'Lviv', 'Ukraine', 'Street', '25');

INSERT INTO public.user_card (id, avatar_url, date_of_birth, email, first_name, gender, last_name, password, phone, registered_on, skype, address_id)
VALUES (1, 'http://example-avatar-url.elect.com', '2017-07-27 10:32:58.556846', 'testEmail@elect.com', 'TestFirstName1', 'Male', 'TestLastName1', 'secretpasswd', '+77-777-7777-777', '2017-07-27 10:32:58.556846', 'skype-example', 1);

INSERT INTO public.category (id, description, image_name, image_url, name)
VALUES (1, 'default description for category 1', 'imageNameForCategory1', 'http://image-for-category-1.elect.com', 'Category1Name');

INSERT INTO public.product (id, description, image_name, image_url, isfamous, name, price, registered_on, category_id, user_id)
VALUES (1, 'test description 1', 'imageName1', 'http://example-image1-url.elect.com', true, 'test Product Name 1', 125, '2017-07-27 10:46:59.357386', 1, 1);
