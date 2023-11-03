package de.hbrs.ia.repository;

import de.hbrs.ia.dto.Salesman;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesmanRepository extends MongoRepository<Salesman, Integer> {
    Salesman findSalesmanByEmployeeID(int employeeID);
    void deleteSalesmanByEmployeeID(int employeeID);
    boolean existsByEmployeeID(int employeeID);
}
