BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, collection, comic_data, character_data, comic_collection, character_comic CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE collection (
    collection_id SERIAL,
    public boolean,
    user_id int REFERENCES users(user_id),
    collection_name varchar(200),
    CONSTRAINT PK_collection PRIMARY KEY (collection_id),
    CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE comic_data(
    comic_id SERIAL,
    upc varchar(200),
    issue_number int,
    series varchar(500),
    publish_date DATE,
    image_url varchar(500),
    author varchar(200),
    artist varchar(200),
    CONSTRAINT PK_comic_id PRIMARY KEY (comic_id)
);

CREATE TABLE character_data(
    character_id SERIAL,
    character_id_marvel_api int,
    name varchar(200),
    CONSTRAINT PK_character_id PRIMARY KEY (character_id)
);


CREATE TABLE comic_collection(
    collection_id int REFERENCES collection(collection_id),
    comic_id int REFERENCES comic_data(comic_id),
    CONSTRAINT FK_collection_id FOREIGN KEY (collection_id) REFERENCES collection(collection_id),
    CONSTRAINT FK_comic_id FOREIGN KEY (comic_id) REFERENCES comic_data(comic_id)
);

CREATE TABLE character_comic (
    character_id int REFERENCES character_data(character_id),
    comic_id int REFERENCES comic_data(comic_id),
    CONSTRAINT FK_character_id FOREIGN KEY (character_id) REFERENCES character_data(character_id),
    CONSTRAINT FK_comic_id FOREIGN KEY (comic_id) REFERENCES comic_data(comic_id)
);


COMMIT TRANSACTION;
