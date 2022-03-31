package com.epam;

import com.epam.entities.Sentence;
import com.epam.logic.FinderSameWord;
import com.epam.logic.Reader;
import com.epam.logic.TextParser;

public class Test {
    public static void main(String[] args) {
        Reader reader = new Reader("text");
        reader.read();
        reader.buildText();
        System.out.println(reader.getText());

        String sourceText = reader.getText();

        TextParser textParser = new TextParser(sourceText);
        Sentence wholeText = textParser.parse();

        wholeText.print();

        System.out.println();

        FinderSameWord finderSameWord = new FinderSameWord();
        finderSameWord.start(wholeText);
    }
}
