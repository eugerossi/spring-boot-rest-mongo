package springmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableWebMvc
@EnableSwagger2
@EnableMongoRepositories(basePackages = "springmongo.repository")
@EnableTransactionManagement
@SpringBootApplication
public class Application implements CommandLineRunner
{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// delete and save a couple of companies
//		companyRepository.deleteAll();
//		companyRepository.save(new Company("7Eleven", 1));
//		companyRepository.save(new Company("Alon", 0));
//		Company company = new Company("GBG", 1);
//		companyRepository.save(company);

		// save a couple of employees
//		employeeRepository.save(new Employee("Laura", "Branigan", 1, company));
// 		employeeRepository.save(new Employee("David", "Bowie", 0, company));
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
