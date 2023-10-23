CREATE TABLE IF NOT EXISTS Content (
    -- This is syntax for h2
    --id INTEGER AUTO_INCREMENT,

    -- This is syntax for postgres
    id SERIAL PRIMARY KEY,

    title VARCHAR(255) NOT NULL,
    -- This is a reserved keyword in postgres. Change to description but annotate java model to use desc
    -- to avoid refactoring.
    --desc TEXT,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
    -- This is for h2
    --PRIMARY KEY (id)
);

--INSERT INTO Content(title, desc, status, content_type, date_created)
--VALUES ('Free Guy', 'My favorite movie', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP)