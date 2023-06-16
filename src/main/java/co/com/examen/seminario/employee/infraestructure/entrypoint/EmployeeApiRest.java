package co.com.examen.seminario.employee.infraestructure.entrypoint;

import co.com.examen.seminario.employee.domain.model.Employee;
import co.com.examen.seminario.employee.infraestructure.entrypoint.employee.EmployeeHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class EmployeeApiRest {
    @Value("{PATH_BASE}")
    private String pathBase;

    @Bean
    public RouterFunction<ServerResponse> userFunctionalEndpoints(EmployeeHandler employeeHandler) {
        String param = "/{id}";
        return RouterFunctions
                .route(POST(pathBase).and(accept(MediaType.APPLICATION_JSON)), employeeHandler::createEmployee);
                /*.andRoute(GET(pathBase).and(accept(MediaType.APPLICATION_JSON)), employeeHandler::queryUsers)
                .andRoute(GET(pathBase.concat(param)).and(accept(MediaType.APPLICATION_JSON)), employeeHandler::queryUserById)
                .andRoute(PUT(pathBase.concat(param)).and(accept(MediaType.APPLICATION_JSON)), employeeHandler::updateUser)
                .andRoute(DELETE(pathBase.concat(param)).and(accept(MediaType.APPLICATION_JSON)),
                        employeeHandler::deleteUser);*/

    }
}
