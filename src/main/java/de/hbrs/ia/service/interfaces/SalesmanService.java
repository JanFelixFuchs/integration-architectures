package de.hbrs.ia.service.interfaces;

import de.hbrs.ia.dto.Salesman;

public interface SalesmanService {
    void createSalesman(Salesman salesman);
    Salesman readSalesman(int employeeID);
    void updateSalesman(Salesman salesman);
    void deleteSalesman(int employeeID);
}
