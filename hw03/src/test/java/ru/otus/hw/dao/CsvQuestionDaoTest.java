//package ru.otus.hw.dao;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import ru.otus.hw.config.AppPropertiesTest;
//import ru.otus.hw.config.TestFileNameProvider;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {AppPropertiesTest.class})
//@TestPropertySource(locations = "/application.properties")
//class CsvQuestionDaoTest {
//
//    @Autowired
//    TestFileNameProvider fileNameProvider;
//
//    @Test
//    @DisplayName("Чтение из тестового ресурса")
//    void findAll_test_1() {
//        CsvQuestionDao csvQuestionDao = new CsvQuestionDao(fileNameProvider);
//        Assertions.assertDoesNotThrow(csvQuestionDao::findAll);
//        Assertions.assertEquals(6, csvQuestionDao.findAll().size());
//    }
//}
