package com.example.internetes_api.repository;

import com.example.internetes_api.domains.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamplesRepository extends JpaRepository<Example, Long> {
}
