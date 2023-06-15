package co.com.examen.seminario.employee.domain.usecase;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.gateways.EmployeeRepository;
import co.com.examen.seminario.employee.infraestructure.entrypoint.employee.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class EmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public Mono<Employee> createEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeDTO.toDomain();
        return employeeRepository.saveEmployee(employee);
    }
}
