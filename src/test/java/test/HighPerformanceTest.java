package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.Salesman;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighPerformanceTest {

    private MongoClient client;
    private MongoDatabase supermongo;
    private MongoCollection<Document> salesmen;

    @BeforeEach
    void setUp() {
        client = new MongoClient("localhost", 27017);
        supermongo = client.getDatabase("highperformance");
        salesmen = supermongo.getCollection("salesmen");
    }

    @Test
    void insertSalesMan() {
        Document document = new Document();
        document.append("firstname" , "Sascha");
        document.append("lastname" , "Alda");
        document.append("id" , 90133);

        salesmen.insertOne(document);

        Document newDocument = this.salesmen.find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        Integer id = (Integer) newDocument.get("id");
        assertEquals( 90133 , id );

        salesmen.drop();
    }

    @Test
    void insertSalesManMoreObjectOriented() {
        Salesman salesMan = new Salesman( "Leslie" , "Malton" , 90444 );

        salesmen.insertOne(salesMan.toDocument());

        Document newDocument = this.salesmen.find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        Integer id = (Integer) newDocument.get("employeeID");
        assertEquals( 90444 , id );

        salesmen.drop();
    }
}