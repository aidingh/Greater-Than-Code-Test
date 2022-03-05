package com.example.greaterthancodetest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Aidin Ghassemloi.
 * BaseModel class containins the base attributes provided by the endpoint.
 * Endpoint provides: status, list of data and a message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModel implements Serializable {

    /**
     * Status: Status of the object.
     */
    public String status;

    /**
     * Data: List of employee data.
     */
    public ArrayList<Employee> data;

    /**
     * Message: Message sent within the object.
     */
    public String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Employee> getData() {
        return data;
    }

    public void setData(ArrayList<Employee> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
