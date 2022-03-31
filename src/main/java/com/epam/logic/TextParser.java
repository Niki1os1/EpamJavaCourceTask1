package com.epam.logic;

import com.epam.entities.LeafSentence;
import com.epam.entities.Sentence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private String text;

    private static final String REGEX_SENTENCE = "([^.!?]+)";
    private static final String REGEX_WORD = "([^,|\\;|\\:|\\=|\\s\\-|\\(|\\)]+)";
    private static final String REGEX_PHONE_NUMBER = "(\\+\\d{3}\\(\\d{2}\\)\\d{3}\\-\\d{2}\\-\\d{2})";
    private static final String REGEX_EMAIL = "([a-zA-Z-_0-9.]+@[a-zA-Z-_0-9]+\\.[a-z]{2,3})";
    private static final String REGEX_WORD_NUMBER_EMAIL = REGEX_WORD + "|" + REGEX_PHONE_NUMBER +
            "|" + REGEX_EMAIL;

    public TextParser(String text) {
        this.text = text;

    }

    public Sentence parse() {
        Sentence sentence = new Sentence();
        parseToSentence(sentence, text);
        return sentence;
    }

    private void parseToSentence(Sentence sentenceList,
                                 String paragraph) {
        // parse to sentence
        Sentence sentence;
        Pattern patternSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher m2 = patternSentence.matcher(paragraph);
        String sen;
        while (m2.find()) {
            sen = m2.group(1);
            //System.out.println(sen);
            sentence = new Sentence();
            parseToWord(sentence, sen);
            sentenceList.addElement(sentence);
        }

    }

    private void parseToWord(Sentence wordList,
                             String sentence) {
        // parse to word
        LeafSentence word;
        Pattern patternWord = Pattern.compile(REGEX_WORD_NUMBER_EMAIL);
        String w;
        Matcher matcher = patternWord.matcher(sentence);
        while (matcher.find()) {
            w = matcher.group(1);
            System.out.println(w);
            word = new LeafSentence(w);
            wordList.addElement(word);
        }
    }
}
