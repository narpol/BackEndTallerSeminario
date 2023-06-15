package co.com.examen.seminario.employee.domain.model.gateways;

import co.com.examen.seminario.employee.domain.model.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {

    Mono<Employee> saveEmployee(Employee employee);

    /*Mono<Employee> updateEmployeeByName(String name);
    Mono<Employee> updateEmployeeByDocument(Integer document);*/
}
