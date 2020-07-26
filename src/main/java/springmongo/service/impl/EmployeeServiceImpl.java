package springmongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import springmongo.entity.Company;
import springmongo.entity.Employee;
import springmongo.repository.EmployeeRepository;
import springmongo.service.EmployeeService;
import springmongo.util.codetype.EmployeeStatus;
import springmongo.util.dto.EmployeeDTO;
import springmongo.util.exception.EmployeeNotFoundException;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private static final Sort SORT_CRITERIA = Sort.by(Sort.Direction.ASC, "lastName", "firstName");

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Employee get(String id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id)
        );
    }

    public List<Employee> findByStatus(Integer status) {
        return status == null ? employeeRepository.findAll(SORT_CRITERIA) : employeeRepository.findByStatus(status, SORT_CRITERIA);
    }

    public List<Employee> findByExample(EmployeeDTO employeeDTO)
    {
        Employee employee = generateEmployeeFromDTO(employeeDTO, false);
        Example employeeExample = Example.of(employee, ExampleMatcher.matchingAll().withIgnoreCase()
                .withIgnoreNullValues()
                /* Criteria for a specific property
                .withMatcher("lastName",
                        //can be replaced with lambda : matcher -> matcher.contains()
                        new ExampleMatcher.MatcherConfigurer<ExampleMatcher.GenericPropertyMatcher>() {
                            @Override
                            public void configureMatcher(ExampleMatcher.GenericPropertyMatcher matcher) {
                                matcher.contains();
                            }
                        })*/
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return employeeRepository.findAll(employeeExample, SORT_CRITERIA);
    }

    @Override
    public List<Employee> getByCompany(String companyId) {
        Employee employee = new Employee();
        Company company = new Company();
        company.setCompanyId(companyId);
        employee.setCompany(company);
        Example employeeExample = Example.of(employee, ExampleMatcher.matching()
                .withMatcher("company",
                        matcher -> matcher.contains()));
        return employeeRepository.findAll(employeeExample, SORT_CRITERIA);
    }

//    private List<Employee> getByCompanyQuery(String companyId)
//    {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("someMap." + mapKey).exists(true));
//        List<Parent> parents = mongoTemplate.find(query,Parent.class);
//        return employees;
//    }

    public void delete(String id)
    {
        employeeRepository.deleteById(id);
    }

    public Employee save(EmployeeDTO employeeDTO)
    {
        return employeeRepository.save(generateEmployeeFromDTO(employeeDTO, true));
    }

    private Employee generateEmployeeFromDTO(EmployeeDTO employeeDTO, boolean initializeStatus) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        if (initializeStatus) {
            employee.setStatus(EmployeeStatus.ACTIVE.getVal());
        }
        return employee;
    }
}
