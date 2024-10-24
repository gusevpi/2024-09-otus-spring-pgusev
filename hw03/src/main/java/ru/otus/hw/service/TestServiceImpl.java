package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;
import ru.otus.hw.service.print.QuestionPrinter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final LocalizedIOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printLineLocalized("TestService.answer.the.questions");
        ioService.printLine("");

        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        questions.forEach(question -> {
            var isValidAnswer = validateAnswer(
                    question.answers(),
                    ioService.readStringWithPrompt(QuestionPrinter.format(question))
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
