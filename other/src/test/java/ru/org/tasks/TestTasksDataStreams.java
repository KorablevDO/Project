package ru.org.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import ru.org.datasurce.StringDataSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestTasksDataStreams {
    private static final Logger LOGGER = LogManager.getLogger(TestTasksDataStreams.class);
    private static final TasksDataStreams DATA_STREAMS = new TasksDataStreams();
    int warAndPeace = 2709701;

    /**
     * 1. Убедитесь, что запрос первых пяти длинных слов не требует вызова метода
            filter (), если найдено пятое длинное слово. С этой целью просто организуйте
            протоколирование вызова каждого метода.
     */
    @Test
    public void protocol(){
        int i = 10;
        List<String> list = DATA_STREAMS.getDataString(10);
        LOGGER.info(list.toString());
        DATA_STREAMS.protocol(list);
    }

    /**
     * 2. Определите разность во времени подсчета длинных слов с помощью методов
            parallelStream () и stream ( ) . Вызовите метод System.currentTimeMillis ()
            до и после этих методов и выведите разность. Если у вас быстродействующий
            компьютер, выберите для подсчета длинных слов более длинный документ (например,
            роман "Война и мир").
     */
    public void comparison(){
        int i = 188088;
        List<String> list = DATA_STREAMS.getDataString(10);
        LOGGER.info(list.toString());

    }

    /**
     * 3. Допустим, что имеется массив int [] values = { 1, 4, 9, 16 }. Каков результат
            вызова Stream.of ( values ) ? Как вместо этого получить поток данных типа int ?
     */
    @Test
    public void intStream(){
        /**
         * Stream.of(values) - получил ошибку компилятора.
         */
        Stream<Integer> stream = DATA_STREAMS.getStreamIntOfList(100);
        IntStream intStream = DATA_STREAMS.getStreamIntOfArrays(100);
    }

    /**
     * 4. С помощью метода Stream, iterate () создайте бесконечный поток случайных
            чисел, не вызывая метод Math, random (), а непосредственно реализуя линейный
            конгруэнтный генератор. Такой генератор начинает действовать с числа, задаваемого
            выражением х0 = начальное значение, а затем производит случайные
            числа по формуле х,| + 1 = (а хп + с) % т, при соответствующих значениях а, с и
            т. С этой целью реализуйте метод, принимающий параметры а, с, т и получающий
            поток данных Stream < Long > . Опробуйте его со следующими параметрами:
            а = 25214903917, с = 11 и т = 2**.
     */
    @Test
    public void t4(){
        int listSize = 10;
        int wordSize = 10;
        List<String> list = StringDataSource.get().getListString(listSize, wordSize);
        LOGGER.info(list.toString());
    }

    /**
     * 5. Метод letters (), упоминавшийся в разделе 8.3, выглядит несколько неуклюже,
            поскольку в нем сначала получается списочный массив, а затем он превращается
            в поток данных. Напишите другой, однострочный вариант этого
            метода, используя поток данных. Преобразуйте значения типа int в пределах
            от 0 до s.length () - 1 с помощью подходящего лямбда-выражения.
     */
    @Test
    public void t5(){

    }

    /**
     * 6. Воспользуйтесь методом String.codePoints () для реализации метода, проверяющего,
            является ли символьная строка словом, состоящим только из букв.
            (Подсказка: воспользуйтесь методом Character.isAlphabetic ().) Реализуйте
            тем же самым способом метод, проверяющий, является ли символьная строка
            достоверным в Java идентификатором.
     */
    @Test
    public void t6(){

    }

    /**
     * 7. Преобразовав содержимое файла в поток лексем, выведите список первых 100
            лексем, являющихся словами в том смысле, в каком они определены в предыдущем
            упражнении. Прочитайте содержимое файла снова и выведите список
            из 10 наиболее часто употребляемых слов, игнорируя регистр букв.
     */
    @Test
    public void t7(){

    }

    /**
     * 8. Прочитайте слова из файла /usr/share/dict/words (или аналогичного списка
            слов) в поток данных и получите массив всех слов, содержащих пять отдельных
            гласных.
     */
    @Test
    public void t8(){

    }

    /**
     * 9. Определите среднюю длину строки в заданном конечном потоке символьных
            строк.
     */
    @Test
    public void t9(){

    }

    /**
     * 10. Определите все символьные строки максимальной длины в заданном конечном
            потоке символьных строк.
     */
    @Test
    public void t10(){

    }

    /**
     * 11
     */
    @Test
    public void t11(){

    }

    /**
     * 12
     */
    @Test
    public void t12(){

    }

    /**
     * 13
     */
    @Test
    public void t13(){

    }

    /**
     * 14
     */
    @Test
    public void t14(){

    }

    /**
     * 15
     */
    @Test
    public void t15(){

    }

    /**
     * 16
     */
    @Test
    public void measuringTime(){
        int i = 188088;
        List<String> list = DATA_STREAMS.getDataString(i);
        LOGGER.info("Size = " + list.size());

        List<String> test = Arrays.asList("adffhfdh","fgsfhrtrtdgfg", "fhcfddt","sgfh","dfgsfhtrebcvdfhdfhs");

        LOGGER.info("Star For");
        List<String> runFor = DATA_STREAMS.runFor(list);
        LOGGER.info("Stop For");
        LOGGER.info("Size result = " + runFor.size());
        LOGGER.info(runFor);

        LOGGER.info("Star Stream");
        List<String> runStream = DATA_STREAMS.runStream(list);
        LOGGER.info("Stop Stream");
        LOGGER.info("Size result = " + runStream.size());
        LOGGER.info(runStream);
    }

    /**
     * 17
     */
    @Test
    public void distinct(){
        List<String> list = StringDataSource.get().getLisStringWitchRepeating();
        LOGGER.info(list);
        List<String> distinct = DATA_STREAMS.distinct(list);
        LOGGER.info(distinct);

        /**
         *  для удаления дубликатов использовал метод distinct
         */
    }
}
