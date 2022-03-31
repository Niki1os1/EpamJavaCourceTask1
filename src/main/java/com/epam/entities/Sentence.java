package com.epam.entities;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Word {
    private final List<Word> wordList = new ArrayList<>();

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public void addElement(Word word) {
        wordList.add(word);
    }


    @Override
    public void removeElement(Word part) {
        wordList.remove(part);
    }

    @Override
    public Word getElement(int index) {
        return wordList.get(index);
    }

    @Override
    public int size() {
        return wordList.size();
    }

    @Override
    public void print() {
        for (Word word : wordList) {
            word.print();
        }
    }

    @Override
    public List<String> getContent() {
        List<String> result = new ArrayList<>();
        for (Word word : wordList) {
            result.addAll(word.getContent());
        }
        return result;
    }
}
