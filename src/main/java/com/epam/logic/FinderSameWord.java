package com.epam.logic;

import com.epam.entities.Sentence;
import com.epam.entities.Word;

import java.util.*;

public class FinderSameWord {
    public static boolean inc(boolean[] arr) {
        int index = 0;
        while (index < arr.length && arr[index]) {
            arr[index] = false;
            index++;
        }
        if (index < arr.length) {
            arr[index] = true;
            return true;
        } else {
            return false;
        }
    }

    public static List<Word> getSelection(Sentence text, boolean[] arr) {
        List<Word> sentences = new ArrayList<>();
        for (int i = 0; i < text.size(); i++) {
            Word sentence = text.getElement(i);
            if (arr[i]) {
                sentences.add(sentence);
            }
        }
        return sentences;
    }

    public static boolean hasSameWords(List<Word> selection) {
        Set<String> words = wordsFromSentence(selection.get(0));
        for (int i = 1; i < selection.size(); i++) {
            words.retainAll(wordsFromSentence(selection.get(i)));
        }
        return !words.isEmpty();
    }

    public static Set<String> wordsFromSentence(Word sentence) {
        return new HashSet<>(sentence.getContent());
    }

        public void start(Sentence sentence) {
        int n = sentence.size();
        boolean[] arr = new boolean[n];
        List<List<Word>> selections = new ArrayList<>();
        do {
            List<Word> selection = getSelection(sentence, arr);
            if (selection.size() > 1 && hasSameWords(selection)) {
                selections.add(selection);
            }
        } while (inc(arr));
        int max = selections.stream().map(s -> s.size()).max(Integer::compareTo).get();

        System.out.println("Count: " + max);
        for (List<Word> words : selections) {
            if (words.size() == max) {
                System.out.println(Arrays.toString(words.stream().map(Word::getContent).toArray()));
            }
        }
    }
}

