package com.Tred.marsApi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bases")
public class MartianCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;
    @Getter @Setter @Column(name = "baseName")
    private String baseName;
    @Getter @Setter @Column(name = "coordinates")
    private String coordinates;

    public MartianCity(){}

    public MartianCity(String baseName, String coordinates){
        this.baseName = baseName;
        this.coordinates = coordinates;
    }

}
