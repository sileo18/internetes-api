package com.example.internetes_api.mapper;

import com.example.internetes_api.domains.Example;
import com.example.internetes_api.domains.Synonyms;
import com.example.internetes_api.domains.Word;
import com.example.internetes_api.dtos.WordCreateRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public record WordMapper() {

    public static Word toEntity(WordCreateRequestDTO dto) {
        Word word = new Word(
                null, // id (gerado automaticamente)
                dto.term(),
                dto.definition(),
                dto.partOfSpeech(),
                new ArrayList<>(), // Inicializa a lista de exemplos
                new ArrayList<>(), // Inicializa a lista de sinônimos
                null // createdAt (será definido no método onCreate)
        );

        List<Example> examples = dto.examples().stream()
                .map(content -> {
                    Example example = new Example(content);
                    example.setWord(word); // Definindo a referência para a palavra
                    return example;
                })
                .collect(Collectors.toList());

        List<Synonyms> synonyms = dto.synonyms().stream()
                .map(content -> {
                    Synonyms synonym = new Synonyms(content);
                    synonym.setWord(word); // Definindo a referência para a palavra
                    return synonym;
                })
                .collect(Collectors.toList());

        word.setExamples(examples);
        word.setSynonyms(synonyms);

        return word;
    }
}