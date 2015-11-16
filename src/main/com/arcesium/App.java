package com.arcesium;

import com.arcesium.mapper.EmployeeMapper;
import com.arcesium.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by amanpsc on 12/11/15.
 */
public class App {
    private static EmployeeMapper eMapper;

    public static void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Configurator.class);
        context.refresh();
        eMapper = context.getBean(EmployeeMapper.class);

        //addEmployee(new Employee(1, "Jagadeesh", null));
        //addEmployee(new Employee(2, "Aman", 1));

        String eName = selectEmployee(1);
        System.out.println(eName);

        Collection<Employee> employees = getAllEmployees();
        System.out.println(employees);

        employees = getAllEmployees(2);
        System.out.println(employees);
    }

    private static Collection<Employee> getAllEmployees(int id) {
        List<Employee> employeesList = (List)getAllEmployees();
        List<Employee> returnList = new ArrayList<>();
        employeesList.stream()
                .filter(emp -> emp.getEid() !=null && emp.getEid() == id)
                .forEach(emp -> returnList.add(emp));
        return returnList;
    }


    private static String selectEmployee(int id) {
        return eMapper.getName(id);
    }

    public static void addEmployee(Employee employee){
        eMapper.insertEmployee(employee);
    }

    public static List<Employee> getAllEmployees() {
        return (List)eMapper.getEmployees();
    }
}
