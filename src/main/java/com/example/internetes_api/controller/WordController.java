package com.example.internetes_api.controller;

import com.example.internetes_api.domains.Word;
import com.example.internetes_api.dtos.WordCreateRequestDTO;
import com.example.internetes_api.mapper.WordMapper;
import com.example.internetes_api.repository.WordRepository;
import com.example.internetes_api.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search")
    public ResponseEntity<List<Word>> search(@RequestParam("q") String query) {
         List<Word> words = wordService.searchBySimilarity(query);

         return ResponseEntity.ok(words);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Word>> getAll(@RequestParam int page, @RequestParam int size) {
        List<Word> words = wordService.findAll(page ,size);

        return ResponseEntity.ok(words);
    }
}
