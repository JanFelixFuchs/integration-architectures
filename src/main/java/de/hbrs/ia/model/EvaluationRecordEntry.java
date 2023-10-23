package de.hbrs.ia.model;

import org.bson.Document;

public class EvaluationRecordEntry {
    private int targetValue;
    private int actualValue;
    private Integer bonus;

    // constructor
    public EvaluationRecordEntry(int targetValue, int actualValue, Integer bonus) {
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.bonus = bonus;
    }

    // method to get the target value of an evaluation record entry
    public int getTargetValue() {
        return targetValue;
    }

    // method to set the target value of an evaluation record entry
    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }

    // method to get the actual value of an evaluation record entry
    public int getActualValue() {
        return actualValue;
    }

    // method to set the actual value of an evaluation record entry
    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    // method to get the bonus of an evaluation record entry
    public Integer getBonus() {
        return bonus;
    }

    // method to set the bonus of an evaluation record entry
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    // method to transform an evaluation record entry into a document
    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("targetValue" , this.targetValue);
        document.append("actualValue" , this.actualValue);
        document.append("bonus" , this.bonus);
        return document;
    }
}
