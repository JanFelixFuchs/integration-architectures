package de.hbrs.ia.controller;

import de.hbrs.ia.dto.EvaluationRecord;
import de.hbrs.ia.service.interfaces.EvaluationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/evaluationRecord")
public class EvaluationRecordController {

    @Autowired
    private EvaluationRecordService evaluationRecordService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<EvaluationRecord> createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        try {
            evaluationRecordService.createEvaluationRecord(evaluationRecord);
            URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path(String.valueOf(evaluationRecord.getEmployeeID()))
                            .buildAndExpand()
                            .toUri();
            HttpHeaders header = new HttpHeaders();
            header.setLocation(location);
            return new ResponseEntity<>(header, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{employeeID}/{year}", method = RequestMethod.GET)
    public ResponseEntity<EvaluationRecord> getEvaluationRecord(@PathVariable int employeeID, @PathVariable  int year) {
        try {
            return new ResponseEntity<>(evaluationRecordService.readEvaluationRecord(employeeID, year), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        try {
            evaluationRecordService.updateEvaluationRecord(evaluationRecord);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path(String.valueOf(evaluationRecord.getEmployeeID()))
                    .buildAndExpand()
                    .toUri();
            HttpHeaders header = new HttpHeaders();
            header.setLocation(location);
            return new ResponseEntity<>(header, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{employeeID}/{year}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEvaluationRecord(@PathVariable int employeeID, @PathVariable int year) {
        try {
            evaluationRecordService.deleteEvaluationRecord(employeeID, year);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
