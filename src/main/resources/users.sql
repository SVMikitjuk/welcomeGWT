
--не получилось в настройках Hibernate
ALTER TABLE users CONVERT TO CHARACTER SET utf8;

INSERT INTO users (id, login, password, name ) VALUES (1, 'ivan', '$5c92d3b144eb64d60e13d76cfe38fe1f$5ecd368267ffb66c4619ee20420e73e7', 'Иван');
INSERT INTO users (id, login, password, name ) VALUES (2, 'john', '$0474c1b002a2da181dc0dd4311378928$a8800aeced49493e8ca8009cdbc9ca08', 'John');
