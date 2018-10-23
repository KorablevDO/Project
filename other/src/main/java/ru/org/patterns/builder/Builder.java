package ru.org.patterns.builder;

public class Builder implements InterfaceBuilder {
    private Message value;

    public Builder(){
        this.value = new Message();
    }

    @Override
    public InterfaceBuilder setValue1(String value) {
        this.value.addLine(value);
        return this;
    }

    @Override
    public InterfaceBuilder setValue2(String value) {
        this.value.addLine(value);
        return this;
    }

    @Override
    public InterfaceBuilder setValue3(String value) {
        this.value.addLine(value);
        return this;
    }

    @Override
    public String getResult() {
        return this.value.getLine();
    }
}
