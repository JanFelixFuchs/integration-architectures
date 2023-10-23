package de.hbrs.ia.model;

import org.bson.Document;

public class EvaluationRecord {
    private int year;
    private int employeeID;
    private EvaluationRecordEntry leadershipCompetence;
    private EvaluationRecordEntry opennessToEmployee;
    private EvaluationRecordEntry socialBehaviorToEmployee;
    private EvaluationRecordEntry attitudeTowardsClient;
    private EvaluationRecordEntry communicationSkills;
    private EvaluationRecordEntry integrityToCompany;
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

    // method to get the year of an evaluation record
    public int getYear() {
        return year;
    }

    // method to set the year of an evaluation record
    public void setYear(int year) {
        this.year = year;
    }

    // method to get the employeeID of an evaluation record
    public int getEmployeeID() {
        return this.employeeID;
    }

    // method to set the employeeID of an evaluation record
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    // method to get the leadership competence of an evaluation record
    public EvaluationRecordEntry getLeadershipCompetence() {
        return leadershipCompetence;
    }

    // method to set the leadership competence of an evaluation record
    public void setLeadershipCompetence(EvaluationRecordEntry leadershipCompetence) {
        this.leadershipCompetence = leadershipCompetence;
    }

    // method to get the openness to employee of an evaluation record
    public EvaluationRecordEntry getOpennessToEmployee() {
        return opennessToEmployee;
    }

    // method to set the openness to employee of an evaluation record
    public void setOpennessToEmployee(EvaluationRecordEntry opennessToEmployee) {
        this.opennessToEmployee = opennessToEmployee;
    }

    // method to get the social behaviour to employee of an evaluation record
    public EvaluationRecordEntry getSocialBehaviorToEmployee() {
        return socialBehaviorToEmployee;
    }

    // method to set the social behaviour to employee of an evaluation record
    public void setSocialBehaviorToEmployee(EvaluationRecordEntry socialBehaviorToEmployee) {
        this.socialBehaviorToEmployee = socialBehaviorToEmployee;
    }

    // method to get the attitude towards client of an evaluation record
    public EvaluationRecordEntry getAttitudeTowardsClient() {
        return attitudeTowardsClient;
    }

    // method to set the attitude towards client of an evaluation record
    public void setAttitudeTowardsClient(EvaluationRecordEntry attitudeTowardsClient) {
        this.attitudeTowardsClient = attitudeTowardsClient;
    }

    // method to get the communication skills of an evaluation record
    public EvaluationRecordEntry getCommunicationSkills() {
        return communicationSkills;
    }

    // method to set the communication skills of an evaluation record
    public void setCommunicationSkills(EvaluationRecordEntry communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    // method to get the integrity to company of an evaluation record
    public EvaluationRecordEntry getIntegrityToCompany() {
        return integrityToCompany;
    }

    // method to set the integrity to company of an evaluation record
    public void setIntegrityToCompany(EvaluationRecordEntry integrityToCompany) {
        this.integrityToCompany = integrityToCompany;
    }

    // method to get the feedback of an evaluation record
    public String getFeedback() {
        return this.feedback;
    }

    // method to set the feedback of an evaluation record
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    // method to transform a evaluation record into a document
    public Document toDocument() {
        org.bson.Document document = new Document();
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
