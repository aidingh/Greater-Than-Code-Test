package com.example.greaterthancodetest.service;

import com.example.greaterthancodetest.models.Employee;
import com.example.greaterthancodetest.models.BaseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * @author Aidin Ghassemloi.
 * EmployeeService class is responsible for making Http-requests.
 * EmployeeService operates as a repository class for EmployeeController class.
 * Employee class instanciates a RestTemplate object provided by Spring web framework.
 */

public class EmployeeService {

    public final RestTemplate restTemplate;
    public static final String BASE_URL = "https://dummy.restapiexample.com/api/v1/employees";

    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Function will attempt to make a Http-request to the base-url.
     * If successful the function will return a list of employees.
     * If request fails function will return null.
     *
     * @return List<Employee> search string containing the track searched by the client.
     */
    public List<Employee> getEmployees()
    {
        ResponseEntity<BaseModel> responseEntity = restTemplate.getForEntity(BASE_URL, BaseModel.class);

        if(responseEntity.getStatusCode() == HttpStatus.OK){
            if(responseEntity.getBody() != null){
                return responseEntity.getBody().data;
            }
            return null;
        }
        return null;
    }
}
