package springmongo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springmongo.entity.Employee;

import java.util.List;

// Exposed as /employeeRepo
@RepositoryRestResource(collectionResourceRel = "employeeRepo", path = "employeeRepo")
public interface EmployeeRESTRepository extends PagingAndSortingRepository<Employee, String> {

    // Access URL: http://localhost:8083/employeeRepo/search/findByLastNameLike?lastName=criteria
    // It will try to match the value from Object property
    public List<Employee> findByLastNameLike(@Param("lastName") String lastName);
}
