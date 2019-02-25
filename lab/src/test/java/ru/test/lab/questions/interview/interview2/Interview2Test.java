package ru.test.lab.questions.interview.interview2;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Interview2Test {
    /**
     *
     Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом.
     Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове. Затем вывести только группы, содержащие более одного элемента.
     Группы должны быть отсортированы в алфавитном порядке по всем буквам в слове.
     Слова внутри группы нужно сортировать по убыванию (по количеству символов);если число символов равное, то сортировать в алфавитном порядке.
     Пример строки: String s = "сапог сарай арбуз болт бокс биржа"
     Отсортированная строка: [б=[биржа, бокс, болт], c=[сaпог, сарай]]
     */
    @Test
    public void task(){
        String line = "сапог сарай арбуз болт бокс биржа";
        System.out.println(line);
        Interview2 interview = new Interview2(line);
        List<String> result = interview.getGroup('с');
        System.out.println(result.toString());
        System.out.println(interview.getMap());
    }
}