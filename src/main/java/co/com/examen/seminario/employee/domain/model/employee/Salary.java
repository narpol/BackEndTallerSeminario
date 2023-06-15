package co.com.examen.seminario.employee.domain.model.employee;

import lombok.Builder;

@Builder
public class Salary {
    private Double value;

    public Double getValue() {
        return value;
    }

}
