package ru.otus.hw.service.print;

import lombok.experimental.UtilityClass;
import ru.otus.hw.domain.Answer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
public class AnswerPrinter implements PrintService {

    public static String format(List<Answer> answers) {
        String formattedAnswers = answers.stream()
                .filter(Objects::nonNull)
                .map(AnswerPrinter::format)
                .collect(Collectors.joining("\n"));
        return formattedAnswers;
    }

    public static String format(Answer answer) {
        return "*   %s".formatted(answer.text());
    }
}
