package ru.tinkoff.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class QueryDTO {
    @NotBlank
    private String text;

    @Size(min = 2, max = 2)
    @Pattern(regexp = "^[a-z]+")
    private String from = "ru";

    @Size(min = 2, max = 2)
    @Pattern(regexp = "^[a-z]+")
    private String to = "en";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
