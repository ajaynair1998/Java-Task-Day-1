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

        connectToDb studentDatabase = new connectToDb();
        studentDatabase.addStudent(4, "new3", 35, "A");
        studentDatabase.listThreeTopStudents();
        studentDatabase.checkIfStudentAlreadyExist(4,"A");
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







