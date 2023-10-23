package de.hbrs.ia.code;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.EvaluationRecordEntry;
import de.hbrs.ia.model.Salesman;
import org.bson.Document;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;

public class Connection implements ManagePersonal {
    private final String host = "localhost";
    private final int port = 27017;
    private final String databaseName = "HooverLtd";
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    // constructor
    public Connection() {
        mongoClient = new MongoClient(host, port);
        database = mongoClient.getDatabase(databaseName);
    }

    @Override
    public void createSalesman(Salesman salesman) {
        MongoCollection<Document> collection = database.getCollection("Salesmen");
        collection.insertOne(salesman.toDocument());
    }

    @Override
    public Salesman readSalesman(int employeeID) {
        MongoCollection<Document> collection = database.getCollection("Salesmen");
        FindIterable<Document> cursor = collection.find(eq("employeeID", employeeID));
        Document resultDocument = null;
        try(final MongoCursor<Document> cursorIterator = cursor.cursor()) {
            if(cursorIterator.hasNext()) resultDocument = cursorIterator.next();
        }
        if(resultDocument == null) return null;
        return new Salesman(
                (String) resultDocument.get("firstName"),
                (String) resultDocument.get("lastName"),
                (int) resultDocument.get("employeeID"));
    }

    @Override
    public void updateSalesman(Salesman salesman) {
        MongoCollection<Document> collection = database.getCollection("Salesmen");
        collection.replaceOne(eq("employeeID", salesman.getEmployeeID()), salesman.toDocument());
    }

    @Override
    public void deleteSalesman(int employeeID) {
        MongoCollection<Document> collection = database.getCollection("Salesmen");
        collection.deleteOne(eq("employeeID", employeeID));
    }

    @Override
    public List<Salesman> querySalesMan(String attribute, String key) {
        MongoCollection<Document> collection = database.getCollection("Salesmen");
        List<Salesman> salesmanList = new ArrayList<>();
        FindIterable<Document> cursor = collection.find(eq(attribute, key));
        try(final MongoCursor<Document> cursorIterator = cursor.cursor()) {
            Document resultDocument = null;
            while(cursorIterator.hasNext()) {
                resultDocument = cursorIterator.next();
                salesmanList.add(new Salesman(
                        (String) resultDocument.get("firstName"),
                        (String) resultDocument.get("lastName"),
                        (int) resultDocument.get("employeeID")));
            }
        }
        return salesmanList;
    }

    @Override
    public void addEvaluationRecord(EvaluationRecord evaluationRecord) {
        MongoCollection<Document> collection = database.getCollection("EvaluationRecords");
        collection.insertOne(evaluationRecord.toDocument());
    }

    @Override
    public List<EvaluationRecord> readEvaluationRecords(int employeeID) {
        MongoCollection<Document> collection = database.getCollection("EvaluationRecords");
        List<EvaluationRecord> evaluationRecordList = new ArrayList<>();
        FindIterable<Document> cursor = collection.find(eq("employeeID", employeeID));
        try(final MongoCursor<Document> cursorIterator = cursor.cursor()) {
            Document resultDocument = null;
            Document documentleadershipCompentence = null;
            Document documentOpennessToEmployee = null;
            Document documentSocialBehaviorToEmployee = null;
            Document documentAttitudeTowardsClient = null;
            Document documentCommunicationSkills = null;
            Document documentIntegrityToCompany = null;
            while(cursorIterator.hasNext()) {
                resultDocument = cursorIterator.next();
                documentleadershipCompentence = (Document) resultDocument.get("leadershipCompetence");
                documentOpennessToEmployee = (Document) resultDocument.get("opennessToEmployee");
                documentSocialBehaviorToEmployee = (Document) resultDocument.get("socialBehaviorToEmployee");
                documentAttitudeTowardsClient = (Document) resultDocument.get("attitudeTowardsClient");
                documentCommunicationSkills = (Document) resultDocument.get("communicationSkills");
                documentIntegrityToCompany = (Document) resultDocument.get("integrityToCompany");
                evaluationRecordList.add(new EvaluationRecord(
                        (int) resultDocument.get("year"),
                        (int) resultDocument.get("employeeID"),
                        new EvaluationRecordEntry(
                                (int) documentleadershipCompentence.get("targetValue"),
                                (int) documentleadershipCompentence.get("actualValue"),
                                documentleadershipCompentence.get("bonus") == null ? null : (Integer) documentleadershipCompentence.get("bonus")),
                        new EvaluationRecordEntry(
                                (int) documentOpennessToEmployee.get("targetValue"),
                                (int) documentOpennessToEmployee.get("actualValue"),
                                documentOpennessToEmployee.get("bonus") == null ? null : (Integer) documentOpennessToEmployee.get("bonus")),
                        new EvaluationRecordEntry(
                                (int) documentSocialBehaviorToEmployee.get("targetValue"),
                                (int) documentSocialBehaviorToEmployee.get("actualValue"),
                                documentSocialBehaviorToEmployee.get("bonus") == null ? null : (Integer) documentSocialBehaviorToEmployee.get("bonus")),
                        new EvaluationRecordEntry(
                                (int) documentAttitudeTowardsClient.get("targetValue"),
                                (int) documentAttitudeTowardsClient.get("actualValue"),
                                documentAttitudeTowardsClient.get("bonus") == null ? null : (Integer) documentAttitudeTowardsClient.get("bonus")),
                        new EvaluationRecordEntry(
                                (int) documentCommunicationSkills.get("targetValue"),
                                (int) documentCommunicationSkills.get("actualValue"),
                                documentCommunicationSkills.get("bonus") == null ? null : (Integer) documentCommunicationSkills.get("bonus")),
                        new EvaluationRecordEntry(
                                (int) documentIntegrityToCompany.get("targetValue"),
                                (int) documentIntegrityToCompany.get("actualValue"),
                                documentIntegrityToCompany.get("bonus") == null ? null : (Integer) documentIntegrityToCompany.get("bonus")),
                        (String) resultDocument.get("feedback")));
            }
        }
        return evaluationRecordList;
    }

    @Override
    public void updateEvaluationRecord(EvaluationRecord evaluationRecord) {
        MongoCollection<Document> collection = database.getCollection("EvaluationRecords");
        collection.replaceOne(and(eq("employeeID", evaluationRecord.getEmployeeID()), eq("year", evaluationRecord.getYear())), evaluationRecord.toDocument());
    }

    @Override
    public void deleteEvaluationRecord(int employeeID, int year) {
        MongoCollection<Document> collection = database.getCollection("EvaluationRecords");
        collection.deleteOne(and(eq("employeeID", employeeID), eq("year", year)));
    }
}
