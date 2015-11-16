package helper;

import com.arcesium.Configurator;
import com.arcesium.mapper.EmployeeMapper;
import com.arcesium.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by amanpsc on 16/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class TestHandler {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private static EmployeeMapper eMapper;

    private List<Employee> employeesList;

    @Before
    public void setUp(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Configurator.class);
        context.refresh();
        eMapper = context.getBean(EmployeeMapper.class);
        employeesList = (List)eMapper.getEmployees();
    }
    @After
    public void tearDown(){
        employeesList.clear();
        // Other sweeping code
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public static EmployeeMapper geteMapper() {
        return eMapper;
    }
}
