package util;

import java.io.PrintWriter;

public class Student implements CSVPrintable{
    Long phoneNumber;
    String name;
    int id;

    public Student(Long phoneNumber, String name, int id) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        String[] fullName = name.split(",");
        return fullName[0] + " " + fullName[1];
    }

    @Override
    public int getID() {
        return id;
    }

    public Long getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public void csvPrintln(PrintWriter out){
        out.println(getName() + "," + getID() + "," + phoneNumber);
        out.flush();

    }
}
