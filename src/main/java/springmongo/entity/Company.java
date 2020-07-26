package springmongo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "company")
public class Company {

    public Company(){}

    public Company(String name, Integer status)
    {
        this.name = name;
        this.status = status;
    }

    // DO NOT use both @Id and @Field("id") annotations together, just one of them
    @Id
    private String companyId;

    @NotNull
    private String name;

    private Integer status;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
