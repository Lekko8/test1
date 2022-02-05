package com.company;

public class ArrMass implements Mass{
    private int massive[];

    private int size = 0;

    public ArrMass(int startSize) {
        massive = new int[startSize];
    }

    public ArrMass(int newMassive[]) {
        massive = newMassive;
        size = massive.length;
    }

    public int size() {
        return size;
    }

    public void add(int newElement) {
        massive[size] = newElement;
        size++;
        normalSize();
    }

    public int get(int index) {
        chekSize(index);
        return massive[index];
    }

    public void add(int index, int element) {
        chekSize(index);
        massive[index] = element;
    }

    public int delete(int index) {
        chekSize(index);
        int temp = massive[index];
        for (; index < size; index++) {
            massive[index] = massive[index + 1];
        }
        size--;
        return temp;
    }

    public void add(int newMassive[]) {
        for (int element : newMassive) {
            add(element);
        }
    }

    public boolean contains(int a) {
        for (int i = 0; i < size; i++) {
            if (massive[i] == a) {
                return true;
            }
        }
        return false;
    }

    public int index(int a) {
        for (int i = 0; i < size; i++) {
            if (massive[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        String stroka = "";
        for (int i = 0; i < size; i++) {
            if (i!=0){
                stroka = stroka + ", " + massive[i] ;
            }else{
                stroka = "" + massive[i];
            }
        }
        return stroka;
    }

    private void chekSize(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("Индекс больше массива.");
        }
    }

    private void normalSize() {
        if (massive.length * 0.7 < size) {
            int[] temp = new int[(int) (massive.length * 1.5) + 1];
            for (int i = 0; i < size; i++) {
                temp[i] = massive[i];
            }
            massive = temp;
        }
    }

}