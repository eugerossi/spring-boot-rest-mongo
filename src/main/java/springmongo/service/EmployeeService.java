package springmongo.service;

import springmongo.entity.Employee;
import springmongo.util.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee get(String id);

    List<Employee> findByStatus(Integer status);

    List<Employee> findByExample(EmployeeDTO example);

    List<Employee> getByCompany(String companyId);

    void delete(String id);

    Employee save(EmployeeDTO employee);
}
