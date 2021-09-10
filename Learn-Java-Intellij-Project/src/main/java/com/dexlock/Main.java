package com.dexlock;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ReadFileAndDoOperations dataFromFile = new ReadFileAndDoOperations("inputFile.txt");

        //TASK ONE
        dataFromFile.numberOfUniqueWords();

        //TASK TWO
        dataFromFile.numberOfOccurrencesOfEachWord();
    }

}

class ReadFileAndDoOperations {
    String currentPath;
    File inputFile;
    Scanner input;
    List<String> wordsFromFile = new ArrayList<>();
    Hashtable<String, Integer> occurrences = new Hashtable<>();

    //    constructor
    public ReadFileAndDoOperations(String s) {
        try {
            this.currentPath = s;
            this.inputFile = new File(currentPath);
            this.input = new Scanner(inputFile);

            //     add all the words to a list of strings
            while (input.hasNext()) {
                String currentWord = input.next();
                wordsFromFile.add(currentWord);

            }


        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
    }

    //    Create a Set from the list we created
    public void numberOfUniqueWords() {

        Set<String> uniqueWords = new HashSet<>(this.wordsFromFile);
        System.out.println("There are " + uniqueWords.size() + " unique words" + "\n");


    }

    //    print the number of occurrence of each word in the file
    public void numberOfOccurrencesOfEachWord() {
        this.wordsFromFile.forEach((word) ->
        {
            if (occurrences.containsKey(word)) {
                occurrences.put(word, occurrences.get(word) + 1);
            } else {
                occurrences.put(word, 1);
            }
        });

        // Print each key and its values
        occurrences.forEach((key, value) -> System.out.println(key + " -> " + value + " time" + "\n"));


    }


}



