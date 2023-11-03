package de.hbrs.ia.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@org.springframework.data.mongodb.core.mapping.Document(collection = "EvaluationRecords")
public class EvaluationRecord {
    @Field("year")
    @Getter
    @Setter
    private int year;

    @Field("employeeID")
    @Getter
    @Setter
    private int employeeID;

    @Field("leadershipCompetence")
    @Getter
    @Setter
    private EvaluationRecordEntry leadershipCompetence;

    @Field("opennessToEmployee")
    @Getter
    @Setter
    private EvaluationRecordEntry opennessToEmployee;

    @Field("socialBehaviorToEmployee")
    @Getter
    @Setter
    private EvaluationRecordEntry socialBehaviorToEmployee;

    @Field("attitudeTowardsClient")
    @Getter
    @Setter
    private EvaluationRecordEntry attitudeTowardsClient;

    @Field("communicationSkills")
    @Getter
    @Setter
    private EvaluationRecordEntry communicationSkills;

    @Field("integrityToCompany")
    @Getter
    @Setter
    private EvaluationRecordEntry integrityToCompany;

    @Field("feedback")
    @Getter
    @Setter
    private String feedback;

    // constructor
    public EvaluationRecord(int year, int employeeID, EvaluationRecordEntry leadershipCompetence, EvaluationRecordEntry opennessToEmployee, EvaluationRecordEntry socialBehaviorToEmployee, EvaluationRecordEntry attitudeTowardsClient, EvaluationRecordEntry communicationSkills, EvaluationRecordEntry integrityToCompany, String feedback) {
        this.year = year;
        this.employeeID = employeeID;
        this.leadershipCompetence = leadershipCompetence;
        this.opennessToEmployee = opennessToEmployee;
        this.socialBehaviorToEmployee = socialBehaviorToEmployee;
        this.attitudeTowardsClient = attitudeTowardsClient;
        this.communicationSkills = communicationSkills;
        this.integrityToCompany = integrityToCompany;
        this.feedback = feedback;
    }

    // method to transform a evaluation record into a document
    public Document toDocument() {
        Document document = new Document();
        document.append("year" , this.year);
        document.append("employeeID", this.employeeID);
        document.append("leadershipCompetence" , this.leadershipCompetence.toDocument());
        document.append("opennessToEmployee" , this.opennessToEmployee.toDocument());
        document.append("socialBehaviorToEmployee" , this.socialBehaviorToEmployee.toDocument());
        document.append("attitudeTowardsClient" , this.attitudeTowardsClient.toDocument());
        document.append("communicationSkills" , this.communicationSkills.toDocument());
        document.append("integrityToCompany" , this.integrityToCompany.toDocument());
        document.append("feedback", this.feedback);
        return document;
    }
}
