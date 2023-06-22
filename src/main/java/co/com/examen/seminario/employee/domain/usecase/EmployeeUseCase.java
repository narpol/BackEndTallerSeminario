package co.com.examen.seminario.employee.domain.usecase;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.gateways.EmployeeRepository;
import co.com.examen.seminario.employee.infraestructure.adapters.entity.EmployeeDBO;
import co.com.examen.seminario.employee.infraestructure.entrypoint.employee.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
public class EmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public Mono<Employee> createEmployee(Employee employee){
        return employeeRepository.saveEmployee(employee);
    }

    public Flux<Employee> findAllEmployee(){
        return employeeRepository.findAllEmployee();
    }

    /*public Mono<Employee> findAllEmployee(){
        return employeeRepository.findAllEmployee();
    }*/


}
