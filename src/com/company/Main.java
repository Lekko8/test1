package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите размер массива: ");
        ArrMass startmassive = new ArrMass(in.nextInt());
        startmassive.add(0);
        startmassive.add(1);
        startmassive.add(2);
        startmassive.add(3);
        startmassive.add(4);
        startmassive.add(5);
        startmassive.add(6);
        startmassive.add(7);
        startmassive.add(8);
        startmassive.add(9);
        startmassive.add(10);
        System.out.println("Элемент №10: " + startmassive.get(10));
        System.out.println("Размер: " + startmassive.size());
        startmassive.add(2, 87);
        System.out.println("Элемент №2: " + startmassive.get(2));
        startmassive.delete(2);
        System.out.println("Элемент №2: " + startmassive.get(2));
        startmassive.add(new int[]{1, 2, 3});
        System.out.println(startmassive.contains(8));
        System.out.println(startmassive.contains(155));
        System.out.println(startmassive);
        ArrMass newmassive = new ArrMass(new int[]{1, 2, 3});
        System.out.println(newmassive.index(5));
    }
}
