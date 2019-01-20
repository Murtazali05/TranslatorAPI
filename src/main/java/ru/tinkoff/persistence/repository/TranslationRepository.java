package ru.tinkoff.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tinkoff.persistence.entity.Translation;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Integer> {

}