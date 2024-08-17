package com.DYC.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;

@Entity
@ToString
public class Member {

    @Id
    public String username;
    public String password;
    public String displayName;

}
