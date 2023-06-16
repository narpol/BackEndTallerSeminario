package co.com.examen.seminario.employee.infraestructure.adapters;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.gateways.EmployeeRepository;
import co.com.examen.seminario.employee.infraestructure.adapters.entity.EmployeeDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class EmployeeDBORepositoryAdapter implements EmployeeRepository {

    private final EmployeeDBORepository employeeDBORepository;

    @Override
    public Mono<Employee> saveEmployee(Employee employee) {

        /*Mono<Employee> monoEmployee = Mono.just(employee);
        return monoEmployee;*/

        EmployeeDBO entity = EmployeeDBO.fromDomain(employee);

        Mono<EmployeeDBO> response = employeeDBORepository.save(entity);

        return response.map(EmployeeDBO::toDomain);

    }
}
