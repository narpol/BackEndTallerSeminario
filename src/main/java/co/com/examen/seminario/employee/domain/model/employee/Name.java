package co.com.examen.seminario.employee.domain.model.employee;

import lombok.Builder;

@Builder
public class Name {
    private String  value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }
}
