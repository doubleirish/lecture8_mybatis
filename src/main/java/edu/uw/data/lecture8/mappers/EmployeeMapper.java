package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Employee;

import java.util.List;

/**
 * Created by Conor on 5/7/2015.
 */
public interface EmployeeMapper {

    // see mapper defintion in src/main/resources/edu/uw/data/lecture8/mappers/EmployeeMapper.xml
     List<Employee> findAllEmployees();

     Employee findById(int id);

    List<Employee> findAllEmployeesWithDetail();

}