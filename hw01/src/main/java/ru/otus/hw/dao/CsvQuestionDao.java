package ru.otus.hw.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.dto.QuestionDto;
import ru.otus.hw.domain.Question;
import ru.otus.hw.exceptions.QuestionReadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {

    private final TestFileNameProvider fileNameProvider;

    @SuppressWarnings("checkstyle:NeedBraces")
    @Override
    public List<Question> findAll() {
        List<QuestionDto> questionRows;
        try (InputStream is = getClass().getResourceAsStream(fileNameProvider.getTestFileName())) {
            if (is == null) {
                throw new QuestionReadException("File not found");
            }
            Reader reader = new BufferedReader(new InputStreamReader(is));

            // Использовать CsvToBean
            // https://opencsv.sourceforge.net/#collection_based_bean_fields_one_to_many_mappings
            questionRows = new CsvToBeanBuilder<QuestionDto>(reader)
                    .withType(QuestionDto.class)
                    .withSeparator(';')
                    .withSkipLines(1)
                    .build()
                    .parse();
        } catch (IOException e) {
            // Использовать QuestionReadException
            throw new QuestionReadException(e.getMessage());
        }
        return questionRows.stream().map(QuestionDto::toDomainObject).toList();
    }
}
