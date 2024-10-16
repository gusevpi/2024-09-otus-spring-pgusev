package ru.otus.hw.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;
import ru.otus.hw.service.print.QuestionPrinter;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    private final QuestionPrinter questionPrinter;

    public TestServiceImpl(IOService ioService,
                           QuestionDao questionDao,
                           @Qualifier("questionPrinter") QuestionPrinter questionPrinter) {
        this.ioService = ioService;
        this.questionDao = questionDao;
        this.questionPrinter = questionPrinter;
    }

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (var question : questions) {
            String userAnswerInput = ioService.readStringWithPrompt(questionPrinter.format(question));
            String correctAnswerIndex = fetchCorrectAnswerIndex(question.answers());
            var isAnswerValid = StringUtils.isNotBlank(correctAnswerIndex) && userAnswerInput.equals(correctAnswerIndex);
            testResult.applyAnswer(question, isAnswerValid);
        }
        return testResult;
    }

    private String fetchCorrectAnswerIndex(List<Answer> answers) {
        if (answers == null) {
            return StringUtils.EMPTY;
        }
        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);
            if (answer != null && answer.isCorrect()) {
                return String.valueOf(i + 1);
            }
        }
        return StringUtils.EMPTY;
    }
}
