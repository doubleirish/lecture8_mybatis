package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * Example of an XML based Mybatis mapper
 *
 *  see mapper defintion in src/main/resources/edu/uw/data/lecture8/mappers/EmployeeMapper.xml
 */
public interface EmployeeMapper {


    // returns employee result as a map , very simple to write
    Map findEmployeeByEmpNum_returnsHashmap(int id);


     List<Employee> findAllEmployees();



    Employee findById(int id);



    Employee findByEmail(String email);

    List<Employee> findAllEmployeesWithDetail();



}