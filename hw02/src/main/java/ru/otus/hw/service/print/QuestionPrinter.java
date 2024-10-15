package ru.otus.hw.service.print;

import org.springframework.stereotype.Component;
import ru.otus.hw.domain.Question;

@Component
public class QuestionPrinter implements PrintService {

    public String format(Question question) {
        return "%s%n%s%n".formatted(question.text(), AnswerPrinter.format(question.answers()));
    }
}
