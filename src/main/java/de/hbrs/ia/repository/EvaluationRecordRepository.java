package de.hbrs.ia.repository;

import de.hbrs.ia.dto.EvaluationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRecordRepository extends MongoRepository<EvaluationRecord, Integer> {
    EvaluationRecord findEvaluationRecordByEmployeeIDAndYear(int employeeID, int year);
    void deleteEvaluationRecordByEmployeeIDAndYear(int employeeID, int year);
    boolean existsByEmployeeIDAndYear(int employeeID, int year);
}
