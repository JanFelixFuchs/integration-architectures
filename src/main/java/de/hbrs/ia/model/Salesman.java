package de.hbrs.ia.model;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salesman {
    private String firstName;
    private String lastName;
    private Integer employeeID;

    // constructor
    public Salesman(String firstName, String lastName, Integer employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
    }

    // method to get the first name of a salesman
    public String getFirstName() {
        return firstName;
    }

    // method to set the first name of a salesman
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // method to get the last name of a salesman
    public String getLastName() {
        return lastName;
    }

    // method to set the last name of a salesman
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // method to get the employee id of a salesman
    public Integer getEmployeeID() {
        return employeeID;
    }

    // method to set the employee id of a salesman
    public void setEmployeeID(Integer id) {
        this.employeeID = id;
    }

    // method to transform a salesman into a document
    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("firstName" , this.firstName);
        document.append("lastName" , this.lastName);
        document.append("employeeID" , this.employeeID);
        return document;
    }
}
