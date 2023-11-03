package de.hbrs.ia.service.interfaces;

import de.hbrs.ia.dto.EvaluationRecord;

public interface EvaluationRecordService {
    void createEvaluationRecord(EvaluationRecord evaluationRecord);
    EvaluationRecord readEvaluationRecord(int employeeID, int year);
    void updateEvaluationRecord(EvaluationRecord evaluationRecord);
    void deleteEvaluationRecord(int employeeID, int year);
}
