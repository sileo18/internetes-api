CREATE TABLE example (
    id SERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    word_id BIGINT NOT NULL,
    CONSTRAINT fk_example_word FOREIGN KEY (word_id) REFERENCES word(id) ON DELETE CASCADE
);