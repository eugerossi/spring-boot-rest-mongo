package springmongo.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import springmongo.entity.Company;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {

    public List<Company> findByStatus(Sort sort, Integer status);

    // It will try to match the value from bo property
    public List<Company> findByName(Sort sort, String name);

    // It will try to match the value from bo property
    public List<Company> findByNameLike(Sort sort, String name);
}

