package util;

import java.util.ArrayList;

public class TA extends Student{
    String name;
    int teacherID, studentID;

    public TA(Long phoneNumber, String name, int teacherID, int studentID) {
        super(phoneNumber, name, teacherID);
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.teacherID = teacherID;
        this.studentID = studentID;

    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getID(){
        if(studentID > teacherID){
            return studentID;
        } else {
            return teacherID;
        }

    }
}
