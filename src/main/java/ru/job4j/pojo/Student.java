package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String surname;
    private String name;
    private String midlName;
    private String group;
    private LocalDate dateOfAdmission;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidlName() {
        return midlName;
    }

    public void setMidlName(String midlName) {
        this.midlName = midlName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission.format(formatter);
    }

    public void setDateOfAdmission(int year, int month, int day) {
        this.dateOfAdmission = LocalDate.of(year, month, day);
    }
}
