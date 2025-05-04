package com.example.internetes_api.service;

import com.example.internetes_api.domains.Word;
import com.example.internetes_api.dtos.WordCreateRequestDTO;
import com.example.internetes_api.mapper.WordMapper;
import com.example.internetes_api.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word create(Word word) {

        return wordRepository.save(word);
    }

    public List<Word> searchBySimilarity(String query) {
        List<Word> words = wordRepository.searchBySimilarity(query);

        return words;
    }
}
