package springmongo.service.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springmongo.entity.Company;
import springmongo.repository.CompanyRepository;
import springmongo.service.CompanyService;
import springmongo.util.exception.CompanyNotFoundException;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    private static final Sort SORT_CRITERIA = Sort.by(Sort.Direction.ASC, "name");

    @Autowired
    private CompanyRepository companyRepository;

    public Company get(String id) {
        return companyRepository.findById(id).orElseThrow(
                () -> new CompanyNotFoundException(id)
        );
    }

    public List<Company> findByStatus(Integer status)
    {
        if (status == null)
        {
            return companyRepository.findAll(SORT_CRITERIA);
        }
        return companyRepository.findByStatus(SORT_CRITERIA, status);
    }

    public List<Company> findByName(String name)
    {
        return companyRepository.findByName(SORT_CRITERIA, name);
    }

    public List<Company> findByNameLike(String name)
    {
        return companyRepository.findByNameLike(SORT_CRITERIA, name);
    }
}
