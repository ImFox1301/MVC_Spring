package net.codejava.entity;

import javax.persistence.*;

@Entity
@Table(name = "service_center")
public class ServiceCenter {

    private Long id;

    private String device_type;

    private String problem;

    private String email;

    public ServiceCenter() {
    }

    public void setId(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
