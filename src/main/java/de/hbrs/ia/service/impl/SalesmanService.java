package de.hbrs.ia.service.impl;

import de.hbrs.ia.dto.Salesman;
import de.hbrs.ia.exception.InvalidInputException;
import de.hbrs.ia.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService implements de.hbrs.ia.service.interfaces.SalesmanService {
    @Autowired
    private SalesmanRepository salesmanRepository;

    @Override
    public void createSalesman(Salesman salesman) {
        if(salesman == null || salesmanRepository.existsByEmployeeID(salesman.getEmployeeID())) {
            throw new InvalidInputException();
        }
        salesmanRepository.insert(salesman);
    }

    @Override
    public Salesman readSalesman(int employeeID) {
        Salesman salesman = salesmanRepository.findSalesmanByEmployeeID(employeeID);
        if(salesman == null) {
            throw new InvalidInputException();
        }
        return salesman;
    }

    @Override
    public void updateSalesman(Salesman salesman) {
        if(salesman == null) {
            throw new InvalidInputException();
        }
        if(salesmanRepository.findSalesmanByEmployeeID(salesman.getEmployeeID()) != null) {
            salesmanRepository.deleteSalesmanByEmployeeID(salesman.getEmployeeID());
        }
        salesmanRepository.insert(salesman);
    }

    @Override
    public void deleteSalesman(int employeeID) {
        if(!salesmanRepository.existsByEmployeeID(employeeID)) {
            throw new InvalidInputException();
        }
        salesmanRepository.deleteSalesmanByEmployeeID(employeeID);
    }
}
