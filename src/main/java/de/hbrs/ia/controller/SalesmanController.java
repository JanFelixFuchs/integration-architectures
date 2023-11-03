package de.hbrs.ia.controller;

import de.hbrs.ia.dto.Salesman;
import de.hbrs.ia.service.interfaces.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createSalesman(@RequestBody Salesman salesman) {
        try {
            salesmanService.createSalesman(salesman);
            URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path(String.valueOf(salesman.getEmployeeID()))
                            .buildAndExpand()
                            .toUri();
            HttpHeaders header = new HttpHeaders();
            header.setLocation(location);
            return new ResponseEntity<>(header, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{employeeID}", method = RequestMethod.GET)
    public ResponseEntity<Salesman> getSalesman(@PathVariable int employeeID) {
        try {
            return new ResponseEntity<>(salesmanService.readSalesman(employeeID), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSalesman(@RequestBody Salesman salesman) {
        try {
            salesmanService.updateSalesman(salesman);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path(String.valueOf(salesman.getEmployeeID()))
                    .buildAndExpand()
                    .toUri();
            HttpHeaders header = new HttpHeaders();
            header.setLocation(location);
            return new ResponseEntity<>(header, HttpStatus.CREATED);
        } catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{employeeID}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSalesman(@PathVariable int employeeID) {
        try {
            salesmanService.deleteSalesman(employeeID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
