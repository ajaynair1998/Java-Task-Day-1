package com.dexlock;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        ReadFileAndDoOperations dataFromFile = new ReadFileAndDoOperations("inputFile.txt");

        System.out.println("Enter the Task ");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextLine()) {
            case "1":
                dataFromFile.numberOfUniqueWords();
                break;
            case "2":
                dataFromFile.numberOfOccurrencesOfEachWord();
                break;
            case "3":
                actionsOnStudentDatabase();
                break;
        }


    }

    public static void actionsOnStudentDatabase() {

        boolean runAgain = true;
        Scanner scanner = new Scanner(System.in);
        String input;

//        Student variables
        String className, studentName;
        int rollNumber, marks;

        connectToDb studentDatabase = new connectToDb();

        ArrayList<String> listOfOperations = new ArrayList<String>(
                Arrays.asList(
                        "Enter the Operation",
                        "1:Insert a new student:",
                        "2:List the students:",
                        "3:List 3 students with top marks:",
                        "4:Exit"
                )
        );

        ArrayList<String> listOfOperationsForStudent = new ArrayList<String>(
                Arrays.asList(
                        "Enter The Student's Name :",
                        "Enter the student's Roll No:",
                        "Enter the class:",
                        "Enter the marks"
                )
        );


        while (runAgain) {
            System.out.println("\n" + listOfOperations.get(0));

            System.out.println("\n" + listOfOperations.get(1));

            System.out.println("\n" + listOfOperations.get(2));

            System.out.println("\n" + listOfOperations.get(3));

            System.out.println("\n" + listOfOperations.get(4));

            input = scanner.nextLine();

            switch (input) {
                case "exit":
                    runAgain = false;
                    break;

                case "1":
                    System.out.println(listOfOperationsForStudent.get(0));
                    studentName = scanner.nextLine();
                    System.out.println(listOfOperationsForStudent.get(1));
                    rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(listOfOperationsForStudent.get(2));
                    className = scanner.nextLine();
                    System.out.println(listOfOperationsForStudent.get(3));
                    marks = scanner.nextInt();

                    if (!studentDatabase.checkIfStudentAlreadyExist(rollNumber, className)) {
                        studentDatabase.addStudent(rollNumber, studentName, marks, className);
                    } else {
                        System.out.println("The student already exists");
                    }
                    break;
                case "2":
                    studentDatabase.listAllStudents();
                    break;
                case "3":
                    studentDatabase.listThreeTopStudents();
                    break;


            }

        }

    }
}







