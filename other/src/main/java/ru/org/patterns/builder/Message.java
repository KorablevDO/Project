package ru.org.patterns.builder;

public class Message {
    private String line;

    public void addLine(String value){
        if(this.line != null){
            this.line = this.line + value;
        } else {
            this.line = value;
        }
    }

    public String getLine(){
        return this.line;
    }
}
