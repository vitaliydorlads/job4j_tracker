package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Петр");
        student.setSurname("Иванов");
        student.setMidlName("Сергеевич");
        student.setGroup("ЗПЭ-162");
        student.setDateOfAdmission(2024, 9, 1);
        System.out.println(student.getName() + System.lineSeparator()
                + student.getSurname() + System.lineSeparator()
                + student.getMidlName() + System.lineSeparator()
                + student.getGroup() + System.lineSeparator()
                + student.getDateOfAdmission());
    }
}
