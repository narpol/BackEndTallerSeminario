package co.com.examen.seminario.employee.infraestructure.entrypoint.employee;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.domain.model.gateways.EmployeeRepository;
import co.com.examen.seminario.employee.domain.usecase.EmployeeUseCase;
import co.com.examen.seminario.employee.infraestructure.adapters.entity.EmployeeDBO;
import co.com.examen.seminario.employee.infraestructure.entrypoint.employee.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class EmployeeHandler {
    private final EmployeeUseCase employeeUseCase;

    public Mono<ServerResponse> createEmployee(ServerRequest serverRequest){
        return serverRequest.bodyToMono(EmployeeDTO.class)
                .flatMap(employeeDTO -> employeeUseCase.createEmployee(employeeDTO.toDomain()))
                .flatMap(savedEmployee -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .bodyValue(savedEmployee))
                .onErrorResume(exception -> ServerResponse
                        .unprocessableEntity()
                        .bodyValue(exception.getMessage()));
    }

    public Mono<ServerResponse> getAllEmployee(ServerRequest serverRequest){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeUseCase.findAllEmployee()
                        .map(emp -> EmployeeDTO.fromDomain(emp)), EmployeeDTO.class);
/*
        return employeeUseCase.findAllEmployee()
                .collectList()
                .flatMap(allEmployee -> ServerResponse
                        .status(HttpStatus.FOUND)
                        .bodyValue(allEmployee.stream(each -> EmployeeDTO.fromDomain(each).toList())))
                .onErrorResume(exception -> ServerResponse
                        .unprocessableEntity()
                        .bodyValue(exception.getMessage()));*/


    }

    public Mono<ServerResponse> findEmploybyId(ServerRequest serverRequest){
        return  employeeUseCase.findEmployeeByDocument(Integer.valueOf(serverRequest.pathVariable("document")))
                .map(employee -> EmployeeDTO.fromDomain(employee))
                .flatMap(employee -> ServerResponse
                        .status(HttpStatus.FOUND)
                        .bodyValue(employee))
                .onErrorResume(exception -> ServerResponse
                        .unprocessableEntity()
                        .bodyValue(exception.getMessage()));
    }
}
