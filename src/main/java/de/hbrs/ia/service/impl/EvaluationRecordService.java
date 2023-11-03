package de.hbrs.ia.service.impl;

import de.hbrs.ia.dto.EvaluationRecord;
import de.hbrs.ia.exception.InvalidInputException;
import de.hbrs.ia.repository.EvaluationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationRecordService implements de.hbrs.ia.service.interfaces.EvaluationRecordService {
    @Autowired
    private EvaluationRecordRepository evaluationRecordRepository;

    @Override
    public void createEvaluationRecord(EvaluationRecord evaluationRecord) {
        if(evaluationRecord == null || evaluationRecordRepository.existsByEmployeeIDAndYear(evaluationRecord.getEmployeeID(), evaluationRecord.getYear())) {
            throw new InvalidInputException();
        }
        evaluationRecordRepository.insert(evaluationRecord);
    }

    @Override
    public EvaluationRecord readEvaluationRecord(int employeeID, int year) {
        EvaluationRecord evaluationRecord = evaluationRecordRepository.findEvaluationRecordByEmployeeIDAndYear(employeeID, year);
        if(evaluationRecord == null) {
            throw new InvalidInputException();
        }
        return evaluationRecord;
    }

    @Override
    public void updateEvaluationRecord(EvaluationRecord evaluationRecord) {
        if(evaluationRecord == null) {
            throw new InvalidInputException();
        }

        if(evaluationRecordRepository.findEvaluationRecordByEmployeeIDAndYear(evaluationRecord.getEmployeeID(), evaluationRecord.getYear()) != null) {
            evaluationRecordRepository.deleteEvaluationRecordByEmployeeIDAndYear(evaluationRecord.getEmployeeID(), evaluationRecord.getYear());
        }
        evaluationRecordRepository.insert(evaluationRecord);
    }

    @Override
    public void deleteEvaluationRecord(int employeeID, int year) {
        if(!evaluationRecordRepository.existsByEmployeeIDAndYear(employeeID, year)) {
            throw new InvalidInputException();
        }
        evaluationRecordRepository.deleteEvaluationRecordByEmployeeIDAndYear(employeeID, year);
    }
}
