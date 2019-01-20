package ru.tinkoff.controller.api;

import io.swagger.annotations.Api;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.service.TranslationService;
import ru.tinkoff.service.dto.QueryDTO;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("api/translate")
@Api(tags="Translator")
public class TranslationController {
    private TranslationService translationService;

    @Autowired
    public void setTranslationService(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping
    public String translate(@Valid QueryDTO queryDTO) throws IOException, ParseException {
        return translationService.translate(queryDTO);
    }
}
