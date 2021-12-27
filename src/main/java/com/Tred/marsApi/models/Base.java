package com.Tred.marsApi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bases")
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
    @Getter @Setter
    private String baseName;
    @Getter @Setter
    private String coordinates;

    public Base(){}

    public Base(String baseName, String coordinates){
        this.baseName = baseName;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Base [id=" + id + ", baseName=" + baseName + ", coordinates=" + coordinates + "]";
    }

}
