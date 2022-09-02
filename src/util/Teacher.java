package util;

import java.io.PrintWriter;

public class Teacher implements CSVPrintable{
    int phoneNumber;
    String name;
    int id;

    public Teacher(Integer phoneNumber, String name, int id) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName(){
        String[] fullName = name.split(",");
        return fullName[0] + " " + fullName[1];
    }

    @Override
    public int getID(){
        return id;
    }

    public Integer getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public void csvPrintln(PrintWriter out){
        out.println(getName() + "," + getID() + "," + phoneNumber);
        out.flush();

    }
}
