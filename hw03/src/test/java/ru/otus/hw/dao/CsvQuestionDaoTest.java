package ru.otus.hw.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.service.TestRunnerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "test.fileNameByLocaleTag.en-US=/questionsTest.csv")
//@SpringBootTest
//@ActiveProfiles("test")
class CsvQuestionDaoTest {

    @Autowired
    TestFileNameProvider fileNameProvider;

    @MockBean
    TestRunnerService testRunnerService;

    @Test
    @DisplayName("Чтение из тестового ресурса")
    void findAll_test_1() {
        CsvQuestionDao csvQuestionDao = new CsvQuestionDao(fileNameProvider);
        Assertions.assertDoesNotThrow(csvQuestionDao::findAll);
        Assertions.assertEquals(6, csvQuestionDao.findAll().size());
    }
}
