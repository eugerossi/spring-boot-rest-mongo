package springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springmongo.repository.CompanyRepository;
import springmongo.repository.EmployeeRepository;

import java.util.ArrayList;

//@EnableSwagger2WebMvc // http://localhost:8083/swagger-ui.html
//@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
//@EnableSwagger2
//@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
@EnableMongoRepositories(basePackages = "springmongo.repository")
@EnableTransactionManagement
@SpringBootApplication
public class Application implements CommandLineRunner
{

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// delete and save a couple of companies
//		companyRepository.deleteAll();
//		companyRepository.save(new Company("7Eleven", 1));
//		companyRepository.save(new Company("Alon", 0));
//		Company company = new Company("GBG", 1);
//		companyRepository.save(company);

		// save a couple of employees
//		employeeRepository.save(new Employee("Laura", "Branigan", 1, company));
// 		employeeRepository.save(new Employee("David", "Bowie", 0, company));
	}

}
