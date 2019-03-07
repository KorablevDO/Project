package org.logparsing;

import java.util.List;
import java.util.stream.Stream;

public class LogParsing {
    private ParsingTemplate parsingTemplate;

    public LogParsing(){

    }

    public LogParsing(ParsingTemplate parsingTemplate){
        this.parsingTemplate = parsingTemplate;
    }

    public LogParsing(Stream<String> stream){

    }

    public List<String> disassemble(){
        return null;
    }
}
