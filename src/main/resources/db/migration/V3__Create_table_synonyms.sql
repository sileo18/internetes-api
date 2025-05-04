CREATE TABLE synonym (
    id SERIAL PRIMARY KEY,
    content VARCHAR(255) NOT NULL,
    word_id BIGINT NOT NULL,
    CONSTRAINT fk_synonym_word FOREIGN KEY (word_id) REFERENCES word(id) ON DELETE CASCADE
);