package ru.otus.hw.service.print;

import lombok.experimental.UtilityClass;
import ru.otus.hw.domain.Question;

@UtilityClass
public class QuestionPrinter implements PrintService {

    public static String format(Question question) {
        return "%s%n%s%n".formatted(question.text(), AnswerPrinter.format(question.answers()));
    }
}
