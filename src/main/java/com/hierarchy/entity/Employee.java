package com.hierarchy.entity;

import javax.persistence.*;

/**
 * Created by chakrabhandari on 13/06/2017.
 */
@Entity
/*@NamedNativeQuery(name = "Employee.findHeirarchyByEmpID",
        query = "WITH RECURSIVE subordinates AS (SELECT employeeName, employeeId, managerId FROM Employee WHERE employeeId = '"+150+"' UNION SELECT e.employeeName, e.employeeId, e.managerId FROM Employee e INNER JOIN subordinates s ON s.employeeId = e.managerId) SELECT * FROM subordinates")*/
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emp_id", nullable = false)
    private String employeeId;

    @Column(name="mgr_id")
    private String managerId;

    @Column(name="emp_name", nullable = false)
    private String employeeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

}
