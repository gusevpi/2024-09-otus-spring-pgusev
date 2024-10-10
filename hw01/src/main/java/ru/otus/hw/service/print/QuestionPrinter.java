package ru.otus.hw.service.print;

import ru.otus.hw.domain.Question;

public class QuestionPrinter implements PrintService {

    public String format(Question question) {
        return "%s%%n%s%%n".formatted(question.text(), AnswerPrinter.format(question.answers()));
    }
}
