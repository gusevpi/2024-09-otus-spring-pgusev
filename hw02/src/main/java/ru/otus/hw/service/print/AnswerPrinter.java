package ru.otus.hw.service.print;

import org.apache.commons.lang3.StringUtils;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnswerPrinter implements PrintService {

    public String format(Question question) {
        return format(question.answers());
    }

    public static String format(List<Answer> answers) {
        return IntStream.range(0, answers.size())
                .mapToObj(index -> format(index + 1, answers.get(index)))
                .collect(Collectors.joining("\n"));
    }

    public static String format(int index, Answer answer) {
        if (Objects.isNull(answer)) {
            return StringUtils.EMPTY;
        }
        return "%d   %s".formatted(index, answer.text());
    }

    public static String format(Answer answer) {
        return "*   %s".formatted(answer.text());
    }
}
