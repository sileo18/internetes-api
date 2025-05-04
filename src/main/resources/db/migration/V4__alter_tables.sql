ALTER TABLE example
    ALTER COLUMN word_id TYPE INTEGER;

ALTER TABLE synonym
    ALTER COLUMN word_id TYPE INTEGER;

CREATE INDEX idx_example_word_id ON example(word_id);
CREATE INDEX idx_synonym_word_id ON synonym(word_id);