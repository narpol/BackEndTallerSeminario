package co.com.examen.seminario.employee.domain.model.employee;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class JobPosition {

    private String value;

    public String getValue() {
        return value;
    }
}
