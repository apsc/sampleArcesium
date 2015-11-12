package com.arcesium;

import com.arcesium.mapper.EmployeeMapper;
import com.arcesium.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by amanpsc on 12/11/15.
 */
public class App {
    static EmployeeMapper eMapper;

    public static void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Configurator.class);
        context.refresh();
        eMapper = context.getBean(EmployeeMapper.class);

        addEmployee(new Employee(1, "Jagadeesh", null));
        addEmployee(new Employee(2, "Aman", 1));
    }

    public static void addEmployee(Employee e){
        eMapper.insertEmployee(e);
    }
}
