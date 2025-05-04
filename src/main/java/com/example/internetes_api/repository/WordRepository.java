package com.example.internetes_api.repository;

import com.example.internetes_api.domains.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    @Query(value = """
    SELECT * FROM word
    WHERE similarity(term, :query) > 0.1
       OR term ILIKE CONCAT('%', :query, '%')
    ORDER BY similarity(term, :query) DESC
    """, nativeQuery = true)
    List<Word> searchBySimilarity(@Param("query") String query);
}
