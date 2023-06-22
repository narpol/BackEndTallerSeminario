package co.com.examen.seminario.employee.domain.model.employee;

import lombok.Builder;

@Builder
public class Document {
    private Integer value;

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Document{" +
                "value=" + value +
                '}';
    }
}
