package com.epam.entities;

import java.util.List;

public interface Word {

    void addElement(Word part);

    void removeElement(Word part);

    Word getElement(int index);

    int size();

    boolean isLeaf();

    void print();

    List<String> getContent();
}
