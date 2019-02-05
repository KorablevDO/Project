package ru.test.lab.tasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.lib.tools.datasurce.FileRandomDataGenerator;
import org.lib.tools.datasurce.NumberRandomGenerator;
import org.lib.tools.datasurce.StringRandomGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestTasksDataStreams {
    private static final TasksDataStreams STREAMS = new TasksDataStreams();
    int warAndPeace = 2709701;

    /**
     * 1. Убедитесь, что запрос первых пяти длинных слов не требует вызова метода
            filter(), если найдено пятое длинное слово. С этой целью просто организуйте
            протоколирование вызова каждого метода.
     */
    @Test
    public void outFirstFiveBigWords(){
        int size = 100;
        int wordSize = 5;
        List<String> list = StringRandomGenerator.getListString(size, wordSize);
        STREAMS.getFirstFiveBigWords(list, wordSize);
    }

    /**
     * 2. Определите разность во времени подсчета длинных слов с помощью методов
            parallelStream() и stream() . Вызовите метод System.currentTimeMillis()
            до и после этих методов и выведите разность. Если у вас быстродействующий
            компьютер, выберите для подсчета длинных слов более длинный документ (например,
            роман "Война и мир").
     */
    @Test
    public void comparisonParallelStreamAndStream(){
        int size = warAndPeace * 5;
        int wordSize = 10;
        int bigWordSize = 8;
        List<String> list1 = StringRandomGenerator.getListString(size, wordSize);
        STREAMS.parallelStreamFilter(list1, bigWordSize);
        List<String> list2 = StringRandomGenerator.getListString(size, wordSize);
        STREAMS.streamFilter(list2, bigWordSize);
        //TODO Переделать вывод времени
    }

    /**
     * 3. Допустим, что имеется массив int[] values = { 1, 4, 9, 16 }. Каков результат
            вызова Stream.of( values ) ? Как вместо этого получить поток данных типа int ?
     */
    @Test
    public void intStream(){
        int size = 10;
        int[] arrayInt = NumberRandomGenerator.getIntArrayNumbers(size);
        IntStream stream = STREAMS.getIntStream(arrayInt);

        /**
         * Stream.of(values) - получил ошибку компилятора.
         * 1. Получить: IntStream intStream = Arrays.stream(array);
         * 2. Получить: Stream<Integer> stream = (Stream<Integer>) Arrays.stream(array);
         */
    }

    /**
     * 4. С помощью метода Stream.iterate() создайте бесконечный поток случайных
            чисел, не вызывая метод Math.random(), а непосредственно реализуя линейный
            конгруэнтный генератор. Такой генератор начинает действовать с числа, задаваемого
            выражением х0 = начальное значение, а затем производит случайные
            числа по формуле х,| + 1 = (а хп + с) % т, при соответствующих значениях а, с и
            т. С этой целью реализуйте метод, принимающий параметры а, с, t и получающий
            поток данных Stream < Long > . Опробуйте его со следующими параметрами:
            а = 25214903917, с = 11 и t = 2^48.
     */
    @Test
    public void generateRandomLongStream(){
        long a = 25214903917L;
        int c = 11;
        long t = (long) Math.pow(2,48);
        Stream<Long> stream = STREAMS.getLongStream(a, c, t);

        int limit = 100;
        List<Long> result = stream.limit(limit).collect(Collectors.toList());
        System.out.println(result);
        /**
         * Числа разные, но при каждой генерации получаются одни и те же.
         */
    }

    /**
     * 5. Метод letters(), упоминавшийся в разделе 8.3, выглядит несколько неуклюже,
            поскольку в нем сначала получается списочный массив, а затем он превращается
            в поток данных. Напишите другой, однострочный вариант этого
            метода, используя поток данных. Преобразуйте значения типа int в пределах
            от 0 до s.length() - 1 с помощью подходящего лямбда-выражения.
     */
    @Test
    public void symbolicallyStringStream(){
        String line = "Преобразовываем строку в поток символов";
        Stream<String> stream = STREAMS.getSymbolicallyStringStream(line);
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 6. Воспользуйтесь методом String.codePoints() для реализации метода, проверяющего,
            является ли символьная строка словом, состоящим только из букв.
            (Подсказка: воспользуйтесь методом Character.isAlphabetic().) Реализуйте
            тем же самым способом метод, проверяющий, является ли символьная строка
            достоверным в Java идентификатором.
     */
    @Test
    public void stringCheck(){
        String line1 = "stream";
        String line2 = "123456789";

        Assert.assertTrue(STREAMS.wordLineTest(line1));
        Assert.assertFalse(STREAMS.wordLineTest(line2));

        String line3 = "_stream";
        String line4 = "Stream1";
        String line5 = "stream";
        String line6 = "1stream";

        Assert.assertTrue(STREAMS.checkStringIdentifier(line3));
        Assert.assertTrue(STREAMS.checkStringIdentifier(line4));
        Assert.assertFalse(STREAMS.checkStringIdentifier(line5));
        Assert.assertFalse(STREAMS.checkStringIdentifier(line6));
    }

    /**
     * 7. Преобразовав содержимое файла в поток лексем, выведите список первых 100
            лексем, являющихся словами в том смысле, в каком они определены в предыдущем
            упражнении. Прочитайте содержимое файла снова и выведите список
            из 10 наиболее часто употребляемых слов, игнорируя регистр букв.
     */
    @Test
    public void fileCheck() throws IOException {
        String path = "src\\test\\resources\\DataPull.dat";
        int size = 1000;
        FileRandomDataGenerator.createDataFile(path, size);

        int limit = 100;
        List<String> result1 = STREAMS.getWordsOfFileWithElements(path, " ", limit);
        System.out.println(result1);

        int frequent = 10;
        List<String> result2 = STREAMS.getFrequentlyUsedWordsFromFileWithElements(path, " ", frequent);
        System.out.println(result2);

        //TODO Необходимо модернизировать генератор данных: 1. надо добавить генерацию слова + цифры 2. задать разделитель для элементов
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
     * 11. Допустим, что ваш непосредственный начальник дал вам задание написать метод
     p u b l i c s t a t i c <Т> b o o le a n i s F i n i t e (S tre a m < T > s t r e a m ). Почему это не самая
     удачная мысль? Все равно напишите этот метод.
     */
    @Test
    public void t11(){

    }

    /**
     * 12. Напишите метод p u b l i c s t a t i c <Т> S t r e a m < T > z i p ( S t r e a m < T > f i r s t ,
     S tre a m < T > s e c o n d ), изменяющий элементы из потоков данных f i r s t и se c o n d
     (или возвращающий пустое значение n u l l , если в потоке данных, черед которого
     настает, исчерпываются элементы).
     */
    @Test
    public void t12(){

    }

    /**
     * 13. Соедините все элементы в потоках данных S t r e a m < A r r a y L i s t < T > > и A r r a y
     L is t < T > . Покажите, как добиться этого с помощью каждой из трех форм метода
     r e d u c e ().
     */
    @Test
    public void t13(){

    }

    /**
     * 14. Организуйте вызов метода re d u c e () таким образом, чтобы вычислить среднее
     в потоке данных S t re a m < D o u b le > . Почему нельзя просто вычислить сумму и
     разделить ее на результат, возвращаемый методом c o u n t () ?
     */
    @Test
    public void t14(){

    }

    /**
     * 15. Найдите 500 простых чисел с 50 десятичными цифрами, используя параллельный
     поток данных типа B i g l n t e g e r и метод B i g l n t e r . i s P r o b a b l e P r i m e ().
     Насколько это делается быстрее, чем при использовании последовательного
     потока данных?
     */
    @Test
    public void t15(){

    }

    /**
     * 16. Найдите 500 самых длинных слов в романе "Война и мир", используя параллельный
     поток данных. Насколько это делается быстрее, чем при использовании
     последовательного потока данных?
     */
    @Test
    public void measuringTime(){
        int i = 188088;
        List<String> list = null;
//        LOGGER.info("Size = " + list.size());

        List<String> test = Arrays.asList("adffhfdh","fgsfhrtrtdgfg", "fhcfddt","sgfh","dfgsfhtrebcvdfhdfhs");

//        LOGGER.info("Star For");
        List<String> runFor = STREAMS.runFor(list);
//        LOGGER.info("Stop For");
//        LOGGER.info("Size result = " + runFor.size());
//        LOGGER.info(runFor);

//        LOGGER.info("Star Stream");
        List<String> runStream = STREAMS.runStream(list);
//        LOGGER.info("Stop Stream");
//        LOGGER.info("Size result = " + runStream.size());
//        LOGGER.info(runStream);
    }

    /**
     * 17. Каким образом можно исключить получение смежных дубликатов из потока
     данных? Сможет ли написанный вами метод обрабатывать параллельный
     поток?
     */
    @Test
    public void distinct(){
//        List<String> list = StringRandomGenerator.getLisStringWitchRepeating();
//        List<String> distinct = STREAMS.distinct(list);


        /**
         *  для удаления дубликатов использовал метод distinct
         */
    }
}