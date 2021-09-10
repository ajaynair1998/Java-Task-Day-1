package com.dexlock;


public class Main {
    public static void main(String[] args) {
        ReadFileAndDoOperations dataFromFile = new ReadFileAndDoOperations("inputFile.txt");

        //TASK ONE
        dataFromFile.numberOfUniqueWords();

        //TASK TWO
        dataFromFile.numberOfOccurrencesOfEachWord();


    }

}







