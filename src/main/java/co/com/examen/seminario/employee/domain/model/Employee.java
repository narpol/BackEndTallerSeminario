package co.com.examen.seminario.employee.domain.model;

import co.com.examen.seminario.employee.domain.model.employee.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


public class Employee {
    private Document document;
    private Name name;
    private StartDay startDay;
    private JobPosition jobPosition;
    private Salary salary;

    public Employee(Document document, Name name, StartDay startDay, JobPosition jobPosition, Salary salary) {
        this.document = document;
        this.name = name;
        this.startDay = startDay;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public Document getDocument() {
        return document;
    }

    public Name getName() {
        return name;
    }

    public StartDay getStartDay() {
        return startDay;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public Salary getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "document=" + document +
                ", name=" + name +
                ", startDay=" + startDay +
                ", jobPosition=" + jobPosition +
                ", salary=" + salary +
                '}';
    }
}
