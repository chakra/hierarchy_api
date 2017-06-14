package com.hierarchy.dao;

import com.hierarchy.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created by chakrabhandari on 13/06/2017.
 */
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "select * from Employee", nativeQuery = true)
    public List<Employee> findByEmpID();

    @Query(value = "WITH RECURSIVE subordinates(id, emp_name, emp_id, mgr_id) as (SELECT id, emp_name, emp_id, mgr_id FROM Employee WHERE emp_id = ?1 UNION ALL SELECT e.id, e.emp_name, e.emp_id, e.mgr_id FROM Employee e INNER JOIN subordinates s ON s.emp_id = e.mgr_id) SELECT id, emp_name, emp_id, mgr_id FROM subordinates", nativeQuery = true  )
    public List<Employee> showHierarchy(@Param("employeeId") String employeeId);

}
