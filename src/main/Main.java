// STUDENT: JADONMICHAEL DE JESUS
// PANTHER ID: 6176454

package main;

import java.io.FileNotFoundException;
import java.util.*;
import util.*;

import java.io.*;

import java.io.PrintWriter;

public class Main {


    private static boolean isValid(String position, String name, String studentID, String teacherID, String phoneNumber) {
        if (position.equals("teacher") && teacherID.length() != 5) {
            return false;
        } else if (position.equals("student") && studentID.length() != 5) {
            return false;
        } else if (position.equals("TA") && studentID.length() != 5 && teacherID.length() != 5) {
            return false;
        }
        if (!name.contains(","))
            return false;
        if (phoneNumber.length() != 10)
            return false;
        if(name.contains(",")){
            int numberOfCommas = 0;
            for(int i = 0; i < name.length(); i++){
                if(name.charAt(i) == ','){
                    numberOfCommas++;
                }
            }
            if(numberOfCommas != 1)
                return false;
        }
        return true;

    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("out.csv");
        PrintWriter pw = new PrintWriter(file);
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        ArrayList list = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("Please enter your amount:");
            int n = keyboard.nextInt();
            if(n < 0){
                System.out.println("Please enter a non-negative integer.");
                continue;
            }
            for (int i = 1; i <= n; i++) {
                command = keyboard.next();
                String position, name, studentID, teacherID, phoneNumber;
                position = command;
                name = keyboard.next();
                studentID = keyboard.next();
                teacherID = keyboard.next();
                phoneNumber = keyboard.next();

                if (isValid(position, name, studentID, teacherID, phoneNumber)) {
                    if (position.equals("teacher")) {
                        list.add(new Teacher(Integer.parseInt(phoneNumber.substring(6, phoneNumber.length())), name, Integer.parseInt(teacherID)));
                    } else if (position.equals("student")) {
                        list.add(new Student(Long.parseLong(phoneNumber), name, Integer.parseInt(studentID)));
                    } else if (position.equals("TA")) {
                        list.add(new TA(Long.parseLong(phoneNumber), name, Integer.parseInt(teacherID), Integer.parseInt(studentID)));
                    }
                    continue;
                }
                i--;
                System.out.println("Please try again!");


            }

                for (Object o : list)
                    if (o instanceof Teacher) {
                        ((Teacher) o).csvPrintln(new PrintWriter(System.out));
                        ((Teacher)o).csvPrintln(pw);
                       } else if (o instanceof Student) {
                         if(o.getClass().equals(Student.class)){
                             ((Student) o).csvPrintln(new PrintWriter(System.out));
                             ((Student)o).csvPrintln(pw);
                            } else if(o.getClass().equals(TA.class)){
                             ((TA) o).csvPrintln(new PrintWriter(System.out));
                             ((TA)o).csvPrintln(pw);
                            }
                        }
                running = false;

                    }
        pw.close();

    }

        }


