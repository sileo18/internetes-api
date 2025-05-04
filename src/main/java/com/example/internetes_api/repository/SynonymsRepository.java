package com.example.internetes_api.repository;


import com.example.internetes_api.domains.Synonyms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SynonymsRepository extends JpaRepository<Synonyms, Long> {
}
