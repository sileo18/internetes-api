package com.example.internetes_api.dtos;

import com.example.internetes_api.domains.Example;
import com.example.internetes_api.domains.Synonyms;

import java.util.List;

public record WordCreateRequestDTO(String term,
                                   String definition,
                                   String partOfSpeech,
                                   List<String> examples,
                                   List<String> synonyms
                                   ) {
}