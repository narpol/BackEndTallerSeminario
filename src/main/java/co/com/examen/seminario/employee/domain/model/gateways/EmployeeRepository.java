package co.com.examen.seminario.employee.domain.model.gateways;

import co.com.examen.seminario.employee.domain.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {

    Mono<Employee> saveEmployee(Employee employee);

    Flux<Employee> findAllEmployee();

    Mono<Employee> findEmployeeByDocument(Integer document);
    //Mono<Employee> findEmployeeByName(String name);


    /*Mono<Employee> updateEmployeeByName(String name);
    Mono<Employee> updateEmployeeByDocument(Integer document);*/
}
