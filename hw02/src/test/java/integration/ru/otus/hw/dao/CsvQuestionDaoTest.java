package integration.ru.otus.hw.dao;

import integration.ru.otus.hw.config.AppPropertiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.exceptions.QuestionReadException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppPropertiesTest.class})
@TestPropertySource(locations = "/application.properties")
class CsvQuestionDaoTest {

    @Test
    @DisplayName("Чтение из несуществующего ресурса c помощью заглушки")
    void findAll_test_2() {
        TestFileNameProvider fileNameProvider = Mockito.mock(TestFileNameProvider.class);
        Mockito.when(fileNameProvider.getTestFileName()).thenReturn("notFound.csv");
        CsvQuestionDao csvQuestionDao = new CsvQuestionDao(fileNameProvider);
        Assertions.assertThrowsExactly(QuestionReadException.class, csvQuestionDao::findAll);
    }
}
