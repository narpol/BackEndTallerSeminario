package co.com.examen.seminario.employee.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


public class Employee {
    private Integer document;
    private String name;
    private LocalDate startDay;
    private String jobPosition;
    private Double salary;

    public Employee(Integer document, String name, LocalDate startDay, String jobPosition, Double salary) {
        this.document = document;
        this.name = name;
        this.startDay = startDay;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public Integer getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public Double getSalary() {
        return salary;
    }
}
