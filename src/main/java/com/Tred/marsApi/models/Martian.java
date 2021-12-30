package com.Tred.marsApi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "martians")
public class Martian implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;
    @Getter @Setter @Column(name = "firstName")
    private String firstName;
    @Getter @Setter @Column(name = "lastName")
    private String lastName;
    @Getter @Setter @Column(name = "age")
    private int age;
    @Getter @Setter @Column(name = "legalId")
    private String legalId;
    @Getter @Setter @Column(name = "faction")
    private String faction;
    @Getter @Setter @Column(name = "baseId")
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
}
