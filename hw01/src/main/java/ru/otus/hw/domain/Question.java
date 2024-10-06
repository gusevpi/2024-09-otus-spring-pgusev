package ru.otus.hw.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public record Question(String text, List<Answer> answers) {

    @Override
    public String toString() {
        String formattedAnswers = answers.stream()
                .filter(Objects::nonNull)
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
        return "%s%%n%s%%n".formatted(this.text, formattedAnswers);
    }
}
