package springmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springmongo.entity.Employee;
import springmongo.service.EmployeeService;
import springmongo.util.dto.EmployeeDTO;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public Employee getEmployeeParam(@RequestParam String id){
        System.out.println("WS Called with id " + id);
        return employeeService.get(id);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeePath(@PathVariable String id) {
        System.out.println("WS Called with id " + id);
        return employeeService.get(id);
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody EmployeeDTO example) {
        System.out.println("WS saveEmployee called with object " + example.toString());
        return employeeService.save(example);
    }

    @DeleteMapping("/")
    public void deleteEmployee(@RequestParam String id) {
        System.out.println("WS deleteEmployee called with id " + id);
        employeeService.delete(id);
    }

    @GetMapping("/list")
    public List<Employee> getEmployees(@RequestParam(required = false) Integer status) {
        return employeeService.findByStatus(status);
    }

    @GetMapping("/list/company")
    public List<Employee> getEmployeesByCompany(@RequestParam String companyId) {
        return employeeService.getByCompany(companyId);
    }

    @PostMapping("/list/example")
    public List<Employee> getEmployeesByExample(@RequestBody EmployeeDTO example){
        System.out.println("WS getEmployeesByExample called with object "+example.toString());
        return employeeService.findByExample(example);
    }
}
