package ru.tinkoff.service;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.persistence.entity.Translation;
import ru.tinkoff.persistence.repository.TranslationRepository;
import ru.tinkoff.service.dto.QueryDTO;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;

@Service
public class TranslationService {
    private TranslationRepository translationRepository;
    private YandexApiService yandexApiService;

    @Autowired
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Autowired
    public void setYandexApiService(YandexApiService yandexApiService) {
        this.yandexApiService = yandexApiService;
    }

    public String translate(QueryDTO queryDTO) throws IOException, ParseException {
        String[] words = queryDTO.getText().replaceAll("[\\-\\+\\.\\^:,!&\\?]", "").toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String output = yandexApiService.translateWord(word, queryDTO.getFrom(), queryDTO.getTo());
            result.append(output).append(" | ");

            Translation translation = new Translation();
            translation.setCalltime(new Timestamp(System.currentTimeMillis()));
            translation.setInput(word);
            translation.setOutput(output);
            translationRepository.save(translation);
        }
        return result.toString();
    }
}
