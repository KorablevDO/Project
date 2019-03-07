package org.logparsing;

import java.util.List;

/**
 * https://habr.com/ru/company/jugru/blog/324932/
 * http://ksuterr.blogspot.com/2016/10/stack-trace-java.html
 */
public class Run {
    public static void main(String[] args) {
        LogParsing parsing = new LogParsing(new ParsingStackTrace());
        List<String> result = parsing.disassemble();
    }
}
