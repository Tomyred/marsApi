package com.Tred.marsApi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "martians")
public class Martian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private String legalId;
    @Getter @Setter
    private String faction;
    @Getter @Setter
    private long baseId;

    public Martian(){}

    public Martian(String firstName, String lastName, int age, String legalId, String faction, long baseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.legalId = legalId;
        this.faction = faction;
        this.baseId = baseId;
    }

    @Override
    public String toString() {
        return "Martian [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", baseId=" + baseId + "]";
    }
}
