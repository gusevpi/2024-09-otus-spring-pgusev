package ru.otus.hw;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.hw.service.TestRunnerService;

@AllArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final TestRunnerService testRunnerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        testRunnerService.run();
    }
}
