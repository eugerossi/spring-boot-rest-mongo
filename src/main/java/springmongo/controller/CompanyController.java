package springmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springmongo.entity.Company;
import springmongo.service.CompanyService;

import java.util.List;


@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public Company getECompanyParam(@RequestParam String id) {
        System.out.println("WS Called with id " + id);
        return companyService.get(id);
    }

    @GetMapping("/list")
    public List<Company> getCompanies(@RequestParam(required = false) Integer status)
    {
        return companyService.findByStatus(status);
    }

    @GetMapping("/list/method")
    public List<Company> getCompanyByNameMethod(@RequestParam String name){
        System.out.println("WS getCompanyByNameMethod called with value "+name);
        return companyService.findByName(name);
    }

    @GetMapping("/list/query")
    public List<Company> getCompanyByNameQuery(@RequestParam String name){
        System.out.println("WS getCompanyByNameMethod called with value "+name);
        return companyService.findByNameLike(name);
    }
}
