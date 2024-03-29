package com.mycompany.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User extends BaseModel{	
	
    @Getter
    @Setter
    @Column(name = "firstName")	
	public String firstName;

    @Getter
    @Setter
    @Column(name = "lastName")    
	public String lastName;

    @Getter
    @Setter
    @Column(name = "email")    
	public String email;
    
    @Getter
    @Setter
    @Column(name = "password", length = 128)
	public String password;
    
    @Getter
    @Setter
    @Column(name = "salt", length = 128)
	public String salt;
}