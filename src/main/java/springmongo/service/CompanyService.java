package springmongo.service;

import springmongo.entity.Company;

import java.util.List;

public interface CompanyService {

    Company get(String id);

    List<Company> findByStatus(Integer status);

    List<Company> findByName(String name);

    List<Company> findByNameLike(String name);
}
