package ru.otus.hw.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw.config.AppProperties;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.exceptions.QuestionReadException;

class CsvQuestionDaoTest {

//    @Test
//    @DisplayName("Чтение из тестового ресурса")
//    void findAll_test_1() {
//        TestFileNameProvider fileNameProvider = new AppProperties("/questionsTest.csv");
//        CsvQuestionDao csvQuestionDao = new CsvQuestionDao(fileNameProvider);
//        Assertions.assertDoesNotThrow(csvQuestionDao::findAll);
//        Assertions.assertEquals(6, csvQuestionDao.findAll().size());
//    }
//
//    @Test
//    @DisplayName("Чтение из несуществующего ресурса")
//    void findAll_test_2() {
//        TestFileNameProvider fileNameProvider = new AppProperties("/notFound.csv");
//        CsvQuestionDao csvQuestionDao = new CsvQuestionDao(fileNameProvider);
//        Assertions.assertThrowsExactly(QuestionReadException.class, csvQuestionDao::findAll);
//    }
}
