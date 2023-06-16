package co.com.examen.seminario.employee.infraestructure.entrypoint.employee.dto;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.employee.*;

import java.time.LocalDate;

public class EmployeeDTO {
    private Integer document;
    private String name;
    private LocalDate startDay;
    private String jobPosition;
    private Float salary;

    public EmployeeDTO(Integer document, String name, LocalDate startDay, String jobPosition, Float salary) {
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

    public Float getSalary() {
        return salary;
    }

    public Employee toDomain(){
        return new Employee(Document.builder().value(document).build(),
                Name.builder().value(name).build(),
                StartDay.builder().value(startDay).build(),
                JobPosition.builder().value(jobPosition).build(),
                Salary.builder().value(salary).build());
    }

    public static EmployeeDTO fromDomain(Employee employee){
        return new EmployeeDTO(employee.getDocument().getValue(),
                employee.getName().getValue(),
                employee.getStartDay().getValue(),
                employee.getJobPosition().getValue(),
                employee.getSalary().getValue());
    }


}
