USE ads_db;

INSERT INTO users (username, email, password) VALUES
  ('bahodge', 'bahodge@email.com', '1234');

INSERT INTO ads (user_id, title, description) VALUES
  (1, 'Playbox', 'An amazing playbox that plays with boxes!!!'),
  (1, 'Cat', 'A CAT THAT EATS CAT FOOD!!!!'),
  (1, 'Doorknob', 'Broken doorknob that was thrown at me'),
  (1, 'Cookies', 'cookies my wife made. They are bad and now my friends hate my wife');
