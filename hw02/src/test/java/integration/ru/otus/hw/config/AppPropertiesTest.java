package integration.ru.otus.hw.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import ru.otus.hw.config.TestConfig;
import ru.otus.hw.config.TestFileNameProvider;

@Data
@Configuration
@TestPropertySource("classpath:application.properties")
public class AppPropertiesTest implements TestConfig, TestFileNameProvider {

    @Value("${test.rightAnswersCountToPass}")
    private int rightAnswersCountToPass;

    @Value("${test.fileName}")
    private String testFileName;
}
