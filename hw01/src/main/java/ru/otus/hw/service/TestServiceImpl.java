package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.config.AppProperties;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Question;

import java.util.List;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        // Получить вопросы из дао и вывести их с вариантами ответов
        QuestionDao questionDao = new CsvQuestionDao(new AppProperties("/questions.csv"));
        List<Question> questionList = questionDao.findAll();
        questionList.forEach(row -> ioService.printFormattedLine(row.toString()));
    }
}
