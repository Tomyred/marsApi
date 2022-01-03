package com.Tred.marsApi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
