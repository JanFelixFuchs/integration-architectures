package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.code.Connection;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.EvaluationRecordEntry;
import de.hbrs.ia.model.Salesman;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ConnectionTest {
    private Connection connection;

    @BeforeEach
    void setUp() {
        connection = new Connection();
    }

    @Test
    void roundTripTest() {
        Salesman salesman = new Salesman("Max", "Mustermann", 123456);
        EvaluationRecord evaluationRecord = new EvaluationRecord(
                2023,
                123456,
                new EvaluationRecordEntry(1, 2, null),
                new EvaluationRecordEntry(1, 2, null),
                new EvaluationRecordEntry(1, 2, null),
                new EvaluationRecordEntry(1, 2, null),
                new EvaluationRecordEntry(1, 2, null),
                new EvaluationRecordEntry(1, 2, null),
                "Test for feedback"
        );

        connection.createSalesman(salesman);
        assertEquals(salesman.getEmployeeID(), connection.readSalesman(salesman.getEmployeeID()).getEmployeeID());

        salesman.setFirstName("Moritz");
        connection.updateSalesman(salesman);
        assertEquals(salesman.getFirstName(), connection.readSalesman(salesman.getEmployeeID()).getFirstName());

        connection.deleteSalesman(salesman.getEmployeeID());
        assertNull(connection.readSalesman(salesman.getEmployeeID()));
    }
}