package ru.otus.hw.service;

import org.springframework.stereotype.Service;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;
import ru.otus.hw.service.print.PrintService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    private final PrintService questionPrinter;

    public TestServiceImpl(IOService ioService,
                           QuestionDao questionDao,
                           PrintService questionPrinter) {
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

        questions.forEach(question -> {
            var isValidAnswer = validateAnswer(
                    question.answers(),
                    ioService.readStringWithPrompt(questionPrinter.format(question))
            );
            testResult.applyAnswer(question, isValidAnswer);
        });
        return testResult;
    }

    boolean validateAnswer(List<Answer> answers, String userAnswerInput) {
        try {
            return answers.get(Integer.parseInt(userAnswerInput) - 1).isCorrect();
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            ioService.printFormattedLine("Wrong input value! Next question:%n");
            return false;
        }
    }
}
