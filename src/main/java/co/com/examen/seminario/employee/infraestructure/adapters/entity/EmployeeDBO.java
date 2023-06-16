package co.com.examen.seminario.employee.infraestructure.adapters.entity;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.employee.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDBO {

    @Id
    @Column("id_document")
    private Integer document;

    @Column("employee_name")
    private String name;

    @Column("start_day")
    private LocalDate startDay;

    @Column("job_position")
    private String jobPosition;

    @Column("salary")
    private Float salary;

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

    public static EmployeeDBO fromDomain(Employee employee){
        return new EmployeeDBO(employee.getDocument().getValue(),
                employee.getName().getValue(),
                employee.getStartDay().getValue(),
                employee.getJobPosition().getValue(),
                employee.getSalary().getValue());
    }


}
