package de.hbrs.ia.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.Field;

public class EvaluationRecordEntry {
    @Field("targetValue")
    @Getter
    @Setter
    private int targetValue;

    @Field("actualValue")
    @Getter
    @Setter
    private int actualValue;

    @Field("bonus")
    @Getter
    @Setter
    private Integer bonus;

    // constructor
    public EvaluationRecordEntry(int targetValue, int actualValue, Integer bonus) {
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.bonus = bonus;
    }

    // method to transform an evaluation record entry into a document
    public Document toDocument() {
        Document document = new Document();
        document.append("targetValue" , this.targetValue);
        document.append("actualValue" , this.actualValue);
        document.append("bonus" , this.bonus);
        return document;
    }
}
