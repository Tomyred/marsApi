package com.Tred.marsApi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "martianCities")
@Audited
public class MartianCity extends Base{


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
