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
    private Integer id_document;

    private String employee_name;

    private LocalDate start_day;

    private String job_position;

    private Float salary;

    public Integer getId_document() {
        return id_document;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public LocalDate getStart_day() {
        return start_day;
    }

    public String getJob_position() {
        return job_position;
    }

    public Float getSalary() {
        return salary;
    }

    public static Employee toDomain(EmployeeDBO employeeDBO){
        return new Employee(Document.builder().value(employeeDBO.getId_document()).build(),
                Name.builder().value(employeeDBO.getEmployee_name()).build(),
                StartDay.builder().value(employeeDBO.getStart_day()).build(),
                JobPosition.builder().value(employeeDBO.getJob_position()).build(),
                Salary.builder().value(employeeDBO.getSalary()).build());
    }

    public static EmployeeDBO fromDomain(Employee employee){
        return EmployeeDBO.builder()
                .id_document(employee.getDocument().getValue())
                .employee_name(employee.getName().getValue())
                .start_day(employee.getStartDay().getValue())
                .job_position(employee.getJobPosition().getValue())
                .salary(employee.getSalary().getValue())
                .build();
    }

    @Override
    public String toString() {
        return "EmployeeDBO{" +
                "id_document=" + id_document +
                ", employee_name='" + employee_name + '\'' +
                ", start_day=" + start_day +
                ", job_position='" + job_position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
