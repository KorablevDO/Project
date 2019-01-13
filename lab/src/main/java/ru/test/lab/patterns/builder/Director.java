package ru.test.lab.patterns.builder;

public class Director {
    private Builder builder;

    public Director(){
        this.builder = new Builder();
    }

    public Director setValue1(String value1){
        this.builder.setValue1(value1);
        return this;
    }

    public Director setValue2(String value1){
        this.builder.setValue2(value1);
        return this;
    }

    public Director setValue3(String value1){
        this.builder.setValue3(value1);
        return this;
    }

    public String getResult(){
        return this.builder.getResult();
    }
}
