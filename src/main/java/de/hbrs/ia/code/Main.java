package de.hbrs.ia.code;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.EvaluationRecordEntry;
import de.hbrs.ia.model.Salesman;
import org.bson.Document;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the scanner-based terminal");
        System.out.println("Please choose an action:");
        loop: while(true) {
            String firstName;
            String lastName;
            int employeeID;
            int year;
            int leadershipCompetenceTargetValue, leadershipCompetenceActualValue, leadershipCompetenceBonus;
            int opennessToEmployeeTargetValue, opennessToEmployeeActualValue, opennessToEmployeeBonus;
            int socialBehaviorToEmployeeTargetValue, socialBehaviorToEmployeeActualValue, socialBehaviorToEmployeeBonus;
            int attitudeTowardsClientTargetValue, attitudeTowardsClientActualValue, attitudeTowardsClientBonus;
            int communicationSkillsTargetValue, communicationSkillsActualValue, communicationSkillsBonus;
            int integrityToCompanyTargetValue, integrityToCompanyActualValue, integrityToCompanyBonus;
            String feedback;
            System.out.println("1: Add a new salesmen");
            System.out.println("2: Read a salesmen");
            System.out.println("3: Update a salesmen");
            System.out.println("4: Delete a salesmen");
            System.out.println("5: Add a new evaluation record");
            System.out.println("6: Read an evaluation record");
            System.out.println("7: Update an evaluation record");
            System.out.println("8: Delete an evaluation record");
            System.out.println("9: Terminate");
            String action = scanner.nextLine();
            switch(action) {
                case "1":
                    System.out.println("First Name:");
                    firstName = scanner.nextLine();
                    System.out.println("Last Name:");
                    lastName = scanner.nextLine();
                    System.out.println("Employee ID:");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    connection.createSalesman(new Salesman(firstName, lastName, employeeID));
                    break;
                case "2":
                    System.out.println("EmployeeID:");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    Salesman result = connection.readSalesman(employeeID);
                    System.out.println(result.toDocument());
                    break;
                case "3":
                    System.out.println("First Name (possibly changed):");
                    firstName = scanner.nextLine();
                    System.out.println("Last Name (possibly changed):");
                    lastName = scanner.nextLine();
                    System.out.println("Employee ID (needs to be unchanged):");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    connection.updateSalesman(new Salesman(firstName, lastName, employeeID));
                    break;
                case "4":
                    System.out.println("EmployeeID:");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    connection.deleteSalesman(employeeID);
                    break;
                case "5":
                    System.out.println("Year:");
                    year = Integer.parseInt(scanner.nextLine());
                    System.out.println("EmployeeID:");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    System.out.println("leadershipCompetenceTargetValue");
                    leadershipCompetenceTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("leadershipCompetenceActualValue");
                    leadershipCompetenceActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("leadershipCompetenceBonus");
                    leadershipCompetenceBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("opennessToEmployeeTargetValue");
                    opennessToEmployeeTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("opennessToEmployeeActualValue");
                    opennessToEmployeeActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("opennessToEmployeeBonus");
                    opennessToEmployeeBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("socialBehaviorToEmployeeTargetValue");
                    socialBehaviorToEmployeeTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("socialBehaviorToEmployeeActualValue");
                    socialBehaviorToEmployeeActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("socialBehaviorToEmployeeBonus");
                    socialBehaviorToEmployeeBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("attitudeTowardsClientTargetValue");
                    attitudeTowardsClientTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("attitudeTowardsClientActualValue");
                    attitudeTowardsClientActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("attitudeTowardsClientBonus");
                    attitudeTowardsClientBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("communicationSkillsTargetValue");
                    communicationSkillsTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("communicationSkillsActualValue");
                    communicationSkillsActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("communicationSkillsBonus");
                    communicationSkillsBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("integrityToCompanyTargetValue");
                    integrityToCompanyTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("integrityToCompanyActualValue");
                    integrityToCompanyActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("integrityToCompanyBonus");
                    integrityToCompanyBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("Feedback:");
                    feedback = scanner.nextLine();

                    connection.addEvaluationRecord(new EvaluationRecord(
                            year,
                            employeeID,
                            new EvaluationRecordEntry(leadershipCompetenceTargetValue, leadershipCompetenceActualValue, leadershipCompetenceBonus),
                            new EvaluationRecordEntry(opennessToEmployeeTargetValue, opennessToEmployeeActualValue, opennessToEmployeeBonus),
                            new EvaluationRecordEntry(socialBehaviorToEmployeeTargetValue, socialBehaviorToEmployeeActualValue, socialBehaviorToEmployeeBonus),
                            new EvaluationRecordEntry(attitudeTowardsClientTargetValue, attitudeTowardsClientActualValue, attitudeTowardsClientBonus),
                            new EvaluationRecordEntry(communicationSkillsTargetValue, communicationSkillsActualValue, communicationSkillsBonus),
                            new EvaluationRecordEntry(integrityToCompanyTargetValue, integrityToCompanyActualValue, integrityToCompanyBonus),
                            feedback
                    ));
                    break;
                case "6":
                    System.out.println("EmployeeID:");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    List<EvaluationRecord> evaluationRecordList = connection.readEvaluationRecords(employeeID);
                    for (EvaluationRecord evaluationRecord: evaluationRecordList) {
                        System.out.println(evaluationRecord.toDocument());
                    }
                    break;
                case "7":
                    System.out.println("Year (needs to be unchanged):");
                    year = Integer.parseInt(scanner.nextLine());
                    System.out.println("EmployeeID (needs to be unchanged):");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    System.out.println("leadershipCompetenceTargetValue");
                    leadershipCompetenceTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("leadershipCompetenceActualValue");
                    leadershipCompetenceActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("leadershipCompetenceBonus");
                    leadershipCompetenceBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("opennessToEmployeeTargetValue");
                    opennessToEmployeeTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("opennessToEmployeeActualValue");
                    opennessToEmployeeActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("opennessToEmployeeBonus");
                    opennessToEmployeeBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("socialBehaviorToEmployeeTargetValue");
                    socialBehaviorToEmployeeTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("socialBehaviorToEmployeeActualValue");
                    socialBehaviorToEmployeeActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("socialBehaviorToEmployeeBonus");
                    socialBehaviorToEmployeeBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("attitudeTowardsClientTargetValue");
                    attitudeTowardsClientTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("attitudeTowardsClientActualValue");
                    attitudeTowardsClientActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("attitudeTowardsClientBonus");
                    attitudeTowardsClientBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("communicationSkillsTargetValue");
                    communicationSkillsTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("communicationSkillsActualValue");
                    communicationSkillsActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("communicationSkillsBonus");
                    communicationSkillsBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("integrityToCompanyTargetValue");
                    integrityToCompanyTargetValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("integrityToCompanyActualValue");
                    integrityToCompanyActualValue = Integer.parseInt(scanner.nextLine());
                    System.out.println("integrityToCompanyBonus");
                    integrityToCompanyBonus = Integer.parseInt(scanner.nextLine());

                    System.out.println("Feedback:");
                    feedback = scanner.nextLine();

                    connection.updateEvaluationRecord(new EvaluationRecord(
                            year,
                            employeeID,
                            new EvaluationRecordEntry(leadershipCompetenceTargetValue, leadershipCompetenceActualValue, leadershipCompetenceBonus),
                            new EvaluationRecordEntry(opennessToEmployeeTargetValue, opennessToEmployeeActualValue, opennessToEmployeeBonus),
                            new EvaluationRecordEntry(socialBehaviorToEmployeeTargetValue, socialBehaviorToEmployeeActualValue, socialBehaviorToEmployeeBonus),
                            new EvaluationRecordEntry(attitudeTowardsClientTargetValue, attitudeTowardsClientActualValue, attitudeTowardsClientBonus),
                            new EvaluationRecordEntry(communicationSkillsTargetValue, communicationSkillsActualValue, communicationSkillsBonus),
                            new EvaluationRecordEntry(integrityToCompanyTargetValue, integrityToCompanyActualValue, integrityToCompanyBonus),
                            feedback
                    ));
                    break;
                case "8":
                    System.out.println("EmployeeID:");
                    employeeID = Integer.parseInt(scanner.nextLine());
                    System.out.println("Year:");
                    year = Integer.parseInt(scanner.nextLine());
                    connection.deleteEvaluationRecord(employeeID, year);
                    break;
                default:
                    System.out.println("Process is going to be terminated");
                    break loop;
            }
        }
    }
}
