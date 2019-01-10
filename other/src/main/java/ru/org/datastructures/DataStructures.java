package ru.org.datastructures;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DataStructures {
    /*
    https://proglib.io/p/8-data-structures/
    https://habr.com/post/237043/
    https://habr.com/post/162017/
     */

    public static void linkDataStructures(){
        //Массив
        int[] array1 = {1,2,3,4};
        int[] array2 = new int[4];

        //Стек
        Stack<Integer> stack = new Stack<>();// Первым пришел, последним ушел или последним пришел, первым ушел
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        //Очередь
        Queue<Integer> queue = new ArrayDeque<>();// Первым пришел, первым ушел
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        //Связный список
        Queue<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        //Графы ?

        //Деревья ?

        //Префиксное дерево ?

        //Хеш-таблица
    }
}
