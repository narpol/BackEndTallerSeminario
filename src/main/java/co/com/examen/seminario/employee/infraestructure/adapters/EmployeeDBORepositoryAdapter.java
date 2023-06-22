package co.com.examen.seminario.employee.infraestructure.adapters;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.gateways.EmployeeRepository;
import co.com.examen.seminario.employee.infraestructure.adapters.entity.EmployeeDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class EmployeeDBORepositoryAdapter implements EmployeeRepository {

    private final EmployeeDBORepository employeeDBORepository;

    @Override
    public Mono<Employee> saveEmployee(Employee employee) {
        return employeeDBORepository.save(EmployeeDBO.fromDomain(employee)).map(EmployeeDBO::toDomain);
    }

    /*@Override
    public Mono<Employee> findAllEmployee() {
        return employeeDBORepository.findAll().collectList();
    }*/

    @Override
    public Flux<Employee> findAllEmployee() {
        return employeeDBORepository.findAll().map(EmployeeDBO::toDomain);
    }
}
