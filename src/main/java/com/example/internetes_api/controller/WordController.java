package com.example.internetes_api.controller;

import com.example.internetes_api.domains.Word;
import com.example.internetes_api.dtos.WordCreateRequestDTO;
import com.example.internetes_api.mapper.WordMapper;
import com.example.internetes_api.repository.WordRepository;
import com.example.internetes_api.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/word")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping("/create")
    public ResponseEntity<Word> createWord(@RequestBody WordCreateRequestDTO request) {

        Word wordSaved =  wordService.create(WordMapper.toEntity(request));

        return ResponseEntity.ok(wordSaved);
    }
}
