package ru.test.lab.questions.interview.interview1;

import org.testng.annotations.Test;

import java.util.List;

public class Interview1Test {
    /**
     * Реализовать метод который выводит число слов в строке.
     */
    @Test
    public void getNumberWords(){
        String line = "dfgsdfg fsdfgshf sdfa fddfg";
        Interview1 interview1 = new Interview1();
        int result = interview1.getNumberWords(line);
        System.out.println(result);
    }

    /**
     * Реализовать метод который убирает дубликаты из массива чисел.
     */
    @Test
    public void getArrayWithoutDuplicates(){
        int[] arr = {1,1,2,2,3,3,3,4};
        Interview1 interview1 = new Interview1();
        int[] result = interview1.removeDuplicates(arr);
        for(int i:result) {
            System.out.println(i);
        }
    }

    /**
     * Реализовать методы класса Project.
     */
    @Test
    public void project(){
        Package package1 = new Package("A");
        Package package2 = new Package("B");
        Package package3 = new Package("C");
        Package package4 = new Package("D");
        Package package5 = new Package("E");
        Package package6 = new Package("F");
        Package package7 = new Package("G");
        Package package8 = new Package("H");
        Package package9 = new Package("M");


        package1.addDependencies(package2);
        package2.addDependencies(package1);
        package2.addDependencies(package2);

        package3.addDependencies(package4);
        package4.addDependencies(package5);
        package5.addDependencies(package3);

        package6.addDependencies(package8);
        package7.addDependencies(package9);

        Project project1 = new Project("Test");
        project1.addPackage(package1);
        project1.addPackage(package2);
        project1.addPackage(package3);
        project1.addPackage(package4);
        project1.addPackage(package5);

        /**
         * Проверить наличие циклических зависимостей между пакетами проекта.
         * Например A->B->A, A->B->C->A
         */
        project1.hasCyclicDependencies();

        /**
         * Получение упорядоченный список проекта для компиляции с учетом их зависимостей.
         */
        List<Package> packages1  = project1.getCompilationOrder();
        System.out.println(packages1);

        Project project2 = new Project("Test");
        project2.addPackage(package6);
        project2.addPackage(package7);

        /**
         * Проверить наличие циклических зависимостей между пакетами проекта.
         * Например A->B->A, A->B->C->A
         */
        project2.hasCyclicDependencies();

        /**
         * Получение упорядоченный список проекта для компиляции с учетом их зависимостей.
         */
        List<Package> packages2  = project2.getCompilationOrder();
        System.out.println(packages2);

        //TODO
    }
}