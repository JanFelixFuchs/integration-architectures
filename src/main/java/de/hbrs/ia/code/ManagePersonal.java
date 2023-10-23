package de.hbrs.ia.code;

import com.mongodb.client.MongoCollection;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.EvaluationRecordEntry;
import de.hbrs.ia.model.Salesman;
import org.bson.Document;

import java.util.List;

public interface ManagePersonal {
    //method to insert a salesman into the database
    void createSalesman(Salesman salesman);

    // method to read a salesman from the database
    Salesman readSalesman(int employeeID);

    // method to update a salesman in the database
    void updateSalesman(Salesman salesman);

    // method to delete a salesman from the database
    void deleteSalesman(int employeeID);

    // method to query multiple salesman
    List<Salesman> querySalesMan(String attribute, String key);

    // method to add an evaluation record to a salesman
    void addEvaluationRecord(EvaluationRecord evaluationRecord);

    // method to read the evaluation records of a salesman
    List<EvaluationRecord> readEvaluationRecords(int employeeID);

    // method to update the evaluation record of a salesman
    void updateEvaluationRecord(EvaluationRecord evaluationRecord);

    // method to delete the evaluation record of a salesman
    void deleteEvaluationRecord(int employeeID, int year);
}
