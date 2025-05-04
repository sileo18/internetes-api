package com.example.internetes_api.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "word")
public class Word {

    public Word() {
    }

    public Word(Long id, String term, String definition, String partOfSpeech, List<Example> examples, List<Synonyms> synonyms, LocalDate createdAt) {
        this.id = id;
        this.term = term;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.examples = examples;
        this.synonyms = synonyms;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String term;


    @Column(columnDefinition = "TEXT")
    private String definition;

    @Column(length = 50)
    private String partOfSpeech;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Example> examples;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Synonyms> synonyms;


    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    public List<Synonyms> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonyms> synonyms) {
        this.synonyms = synonyms;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
