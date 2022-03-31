package com.epam.logic;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private final String fileName;
    private List<String> strings = new ArrayList<>();
    private StringBuilder text = new StringBuilder();

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void read() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
             InputStreamReader reader = new InputStreamReader(is)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void buildText() {
        for (String string : strings) {
            text.append(string).append(" ");
        }
    }

    public List<String> getStrings() {
        return strings;
    }

    public String getText() {
        return text.toString();
    }
}
