package com.dexlock;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ReadFileAndDoOperations dataFromFile = new ReadFileAndDoOperations("inputFile.txt");

        //TASK ONE
        dataFromFile.numberOfUniqueWords();

        //TASK TWO
        dataFromFile.numberOfOccurrencesOfEachWord();

        connectToDb connect=new connectToDb();
    }

    public static void switchBetweenTasks() {
        Scanner scannerObject = new Scanner(System.in);

        try {
            while (true) {
                Runtime.getRuntime().exec("clear");

                System.out.println("Select the task to run \n Press 0 to exit");

                int taskNumber = scannerObject.nextInt();
                System.out.println(taskNumber);

            }
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

}







