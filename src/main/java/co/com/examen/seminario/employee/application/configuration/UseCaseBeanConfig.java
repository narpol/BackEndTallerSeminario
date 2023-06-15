package co.com.examen.seminario.employee.application.configuration;


import co.com.examen.seminario.employee.domain.model.gateways.EmployeeRepository;
import co.com.examen.seminario.employee.domain.usecase.EmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public EmployeeUseCase employeeUseCase(EmployeeRepository employeeRepository){
        return new EmployeeUseCase(employeeRepository);
    }
}
