package co.com.examen.seminario.employee.domain.model.employee;

import lombok.Builder;

@Builder
public class Salary {
    private Float value;

    public Float getValue() {
        return value;
    }

}
