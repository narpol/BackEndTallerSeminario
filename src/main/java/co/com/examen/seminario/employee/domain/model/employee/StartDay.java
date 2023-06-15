package co.com.examen.seminario.employee.domain.model.employee;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class StartDay {

    private LocalDate value;

    public LocalDate getValue() {
        return value;
    }
}
