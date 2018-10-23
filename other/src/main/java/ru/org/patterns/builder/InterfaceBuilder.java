package ru.org.patterns.builder;

public interface InterfaceBuilder {
    public InterfaceBuilder setValue1(String value);
    public InterfaceBuilder setValue2(String value);
    public InterfaceBuilder setValue3(String value);
    public String getResult();
}
