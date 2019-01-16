package ru.test.lab.patterns.fencing.builder;

/**
 * Паттерн Builder - строитель. Отвечает за сбор обьекта. Для паттерна реализован класс director который выполняет роль
 * обертки для builder.
 */
public class Builder implements InterfaceBuilder {
    private Message value;

    public Builder(){
        this.value = new Message();
    }

    @Override
    public void setValue1(String value) {
        this.value.addLine(value);
    }

    @Override
    public void setValue2(String value) {
        this.value.addLine(value);
    }

    @Override
    public void setValue3(String value) {
        this.value.addLine(value);
    }

    @Override
    public String getResult() {
        return this.value.getLine();
    }
}
