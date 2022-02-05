package com.company;

import java.util.LinkedList;

public class LinkMass implements Mass {

    private int number;

    private LinkMass back;

    private LinkMass next;

    public LinkMass(int number) {
        this.number = number;
        back = null;
        next = null;
    }

    public void add(int number) {
        next = new LinkMass(number);
        next.setBack(this);
    }

    public LinkMass getLast() {
        if (next == null) {
            return this;
        } else {
            return next.getLast();
        }
    }

    public LinkMass getFirst() {
        if (back == null) {
            return this;
        } else {
            return back.getFirst();
        }
    }

    public void addLast(int number) {
        LinkMass temp = getLast();
        temp.setNext(new LinkMass(number));
        temp.next.setBack(temp);
    }

    public void addFirst(int number) {
        LinkMass temp = getFirst();
        temp.setBack(new LinkMass(number));
        temp.back.setNext(temp);
    }

    public int index(int number) {
        int i = 0;
        LinkMass temp = getFirst();
        while (temp != null) {
            if (temp.number == number) {
                break;
            } else {
                i++;
                temp = temp.next;
            }
        }
        if (temp != null) {
            return i;
        } else {
            return -1;
        }
    }

    public boolean contains(int number) {
        return index(number) != -1;
    }

    @Override
    public int get(int index) {
        return get_(index).number;
    }

    private LinkMass get_(int index) {
        LinkMass temp = getFirst();
        for (int i = 0; i != index; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IllegalArgumentException("Индекс больше массива.");
            }
        }
        return temp;
    }

    public int get(){
        return number;
    }

    @Override
    public int delete(int index) {
        LinkMass temp = get_(index);
        temp.next.setBack(back);
        temp.back.setNext(next);
        return temp.number;
    }

    public int remove(){
        LinkMass temp = getFirst();
        temp.next.setBack(null);
        return temp.number;
    }

    private void setNext(LinkMass next) {
        this.next = next;
    }

    private void setBack(LinkMass back) {
        this.back = back;
    }
}
