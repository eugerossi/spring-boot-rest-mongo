package springmongo.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import springmongo.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public List<Employee> findByStatus(Integer status, Sort sort);

    public List<Employee> getByCompany(Integer company, Sort sort);

}

