package com.mypet.mypet.domain.complementares;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Regioes implements Serializable {

    private static final long serialVersionUID = 1l;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

   private String regiao;

}
