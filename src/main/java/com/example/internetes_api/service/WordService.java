package com.example.internetes_api.service;

import com.example.internetes_api.domains.Word;
import com.example.internetes_api.repository.WordRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Word> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return wordRepository.findAllByPage(pageable);
    }

    public Word findById(Long id) {
        return wordRepository.findById(id).orElseThrow(() -> new RuntimeException("Word not found"));
    }
}
