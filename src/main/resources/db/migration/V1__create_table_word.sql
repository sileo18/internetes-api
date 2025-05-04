CREATE EXTENSION IF NOT EXISTS pg_trgm;

CREATE TABLE word (
    id SERIAL PRIMARY KEY,
    term VARCHAR(255) NOT NULL UNIQUE,
    definition TEXT NOT NULL,
    part_of_speech VARCHAR(50), --verbo, substantivo
    examples TEXT[],
    synonyms TEXT[],
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_word_term_trgm ON word USING GIN (term gin_trgm_ops);