package de.hbrs.ia.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@org.springframework.data.mongodb.core.mapping.Document(collection = "Salesmen")
public class Salesman {
    @Field("firstName")
    @Getter
    @Setter
    private String firstName;

    @Field("lastName")
    @Getter
    @Setter
    private String lastName;

    @Field("employeeID")
    @Getter
    @Setter
    private Integer employeeID;

    // constructor
    public Salesman(String firstName, String lastName, Integer employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
    }

    // method to transform a salesman into a document
    public Document toDocument() {
        Document document = new Document();
        document.append("firstName" , this.firstName);
        document.append("lastName" , this.lastName);
        document.append("employeeID" , this.employeeID);
        return document;
    }
}
