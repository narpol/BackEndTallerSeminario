package co.com.examen.seminario.employee.infraestructure.entrypoint.employee;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.gateways.EmployeeRepository;
import co.com.examen.seminario.employee.domain.usecase.EmployeeUseCase;
import co.com.examen.seminario.employee.infraestructure.adapters.entity.EmployeeDBO;
import co.com.examen.seminario.employee.infraestructure.entrypoint.employee.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class EmployeeHandler {
    private final EmployeeUseCase employeeUseCase;

    public Mono<ServerResponse> createEmployee(ServerRequest serverRequest){
        return serverRequest
                .bodyToMono(EmployeeDTO.class)
                .flatMap(employeeDTO -> employeeUseCase.createEmployee(employeeDTO))
                .flatMap(savedEmployee -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .bodyValue(savedEmployee))
                .onErrorResume(exception -> ServerResponse
                        .unprocessableEntity()
                        .bodyValue(exception.getMessage()));
    }
}
