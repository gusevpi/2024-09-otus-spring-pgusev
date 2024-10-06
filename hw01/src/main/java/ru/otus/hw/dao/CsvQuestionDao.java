package ru.otus.hw.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import ru.otus.hw.Application;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.dto.QuestionDto;
import ru.otus.hw.domain.Question;
import ru.otus.hw.exceptions.QuestionReadException;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {

    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {
        List<QuestionDto> questionRows;
        try {
            // Про ресурсы: https://mkyong.com/java/java-read-a-file-from-resources-folder/
            URL url = Objects.requireNonNull(Application.class.getResource(fileNameProvider.getTestFileName()));
            Path resourcePath = Paths.get(url.toURI());
            Reader reader = Files.newBufferedReader(resourcePath);

            // Использовать CsvToBean
            // https://opencsv.sourceforge.net/#collection_based_bean_fields_one_to_many_mappings
            questionRows = new CsvToBeanBuilder<QuestionDto>(reader)
                    .withType(QuestionDto.class)
                    .withSeparator(';')
                    .withSkipLines(1)
                    .build()
                    .parse();
        } catch (URISyntaxException | IOException e) {
            // Использовать QuestionReadException
            throw new QuestionReadException(e.getMessage());
        }
        return questionRows.stream().map(QuestionDto::toDomainObject).toList();
    }
}
