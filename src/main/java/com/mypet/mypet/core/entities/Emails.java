package com.mypet.mypet.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"emailId"})
@Entity
@Table(name = "EMAILS")
public class Emails implements Serializable {

        private static final long serialVersionUID =1l;


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private long emailId;

        private String emailTipo;
        private String email;
       // private String emailCpf;

       // @ManyToOne
      //  @JoinColumn(name = "enderecos_id")

}
