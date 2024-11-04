package ru.otus.hw.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.hw.config.TestFileNameProvider;

@ExtendWith(SpringExtension.class)
class CsvQuestionDaoTest {

    @Test
    @DisplayName("Чтение из тестового ресурса")
    void findAll_test_1() {
        TestFileNameProvider fileNameProvider = () -> "/questionsTest.csv";
        CsvQuestionDao csvQuestionDao = new CsvQuestionDao(fileNameProvider);
        Assertions.assertDoesNotThrow(csvQuestionDao::findAll);
        Assertions.assertEquals(6, csvQuestionDao.findAll().size());
    }
}
