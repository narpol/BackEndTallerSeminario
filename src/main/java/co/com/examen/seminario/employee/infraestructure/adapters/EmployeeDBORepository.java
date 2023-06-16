package co.com.examen.seminario.employee.infraestructure.adapters;

import co.com.examen.seminario.employee.infraestructure.adapters.entity.EmployeeDBO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeDBORepository extends ReactiveCrudRepository<EmployeeDBO, Integer> {

}
