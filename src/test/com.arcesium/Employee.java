package com.arcesium;

import helper.TestHandler;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


/**
 * Created by amanpsc on 16/11/15.
 */
public class Employee extends TestHandler {

    @Test
    public void canPopulateEmployeeListNotNull(){
        assertThat(getEmployeesList(), hasSize(48));
    }

    @Test
    public void canAddEmployee(){
        geteMapper().insertEmployee(new com.arcesium.model.Employee(3, "TempTest", 1));
        assertThat(geteMapper().getEmployees(), hasSize(49));
    }

    @Test
    public void canDeleteEmployee(){
        geteMapper().deleteEmployee(3);
        assertThat(geteMapper().getEmployees(), hasSize(48));
    }

    @Test
    public void canUpdateEmployee(){
        geteMapper().insertEmployee(new com.arcesium.model.Employee(3, "TempTest", 1));
        geteMapper().updateName("updatedString", 3);
        assertThat(geteMapper().getName(3), is("updatedString"));
        geteMapper().deleteEmployee(3);
    }

    @Test
    public void canGetEmployeeDetails(){
        assertThat(getEmployeesList().get(0), hasProperty("name", is("Jagadeesh")));
        assertThat(getEmployeesList().get(0), hasProperty("eid", is(1)));
        assertThat(getEmployeesList().get(0), hasProperty("mid", is(nullValue())));
        assertThat(getEmployeesList().get(1), hasProperty("name", is("Aman")));
        assertThat(getEmployeesList().get(1), hasProperty("eid", is(2)));
        assertThat(getEmployeesList().get(1), hasProperty("mid", is(1)));
    }

    @Test
    public void testWithInvalidOperation() throws NullPointerException{
        expectedException.expect(NullPointerException.class);
        getEmployeesList().get(0).getMid().intValue();
    }
}
