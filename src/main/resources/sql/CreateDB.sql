CREATE TABLE USERS(ID INT PRIMARY KEY, LOGIN VARCHAR(50) NOT NULL UNIQUE, NAME VARCHAR(50), LAST_NAME VARCHAR(50),
EMAIL VARCHAR(100), PASSWORD VARCHAR(200), ROLE_ID INTEGER, ACTIVE BOOLEAN);

INSERT INTO USERS VALUES(1,'Alex1986','Alexandr', 'Sumaneyew', 'dd@dd.ru', 'qwerty', 3, TRUE );
INSERT INTO USERS VALUES(1,'Alexey1960','Alexey', 'Alexeevich', 'lexa@dd.ru', '123', 2, TRUE );
