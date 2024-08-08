package ru.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иванов Василий Петрович");
        student.setGroup(5);
        student.setDateStudy(new Date());
        System.out.println(student.getName() + ", учится в " + student.getGroup()
                + " группе, поступил " + student.getDateStudy() + ".");
    }
}
