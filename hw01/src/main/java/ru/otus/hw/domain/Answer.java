package ru.otus.hw.domain;

public record Answer(String text, boolean isCorrect) {

    @Override
    public String toString() {
        return "*   %s".formatted(this.text);
    }
}
