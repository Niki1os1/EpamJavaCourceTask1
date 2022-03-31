package com.epam.entities;

import java.util.ArrayList;
import java.util.List;

public class LeafSentence implements Word {
    private String str;

    @Override
    public boolean isLeaf() {
        return true;
    }

    public LeafSentence(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    @Override
    public void addElement(Word word) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(Word word) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Word getElement(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print() {
        System.out.print(this.str + " ");
    }

    @Override
    public List<String> getContent() {
        List<String> result = new ArrayList<>(1);
        result.add(str);
        return result;
    }

}
