package integration.ru.otus.hw.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.exceptions.QuestionReadException;


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
