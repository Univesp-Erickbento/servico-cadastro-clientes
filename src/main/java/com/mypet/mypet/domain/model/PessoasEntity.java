package com.mypet.mypet.domain.model;

//import com.mypet.mypet.domain.model.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Data
@EqualsAndHashCode(of = {"id"})
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED) // ou SINGLE_TABLE, TABLE_PER_CLASS
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "perfis")
@Entity
@Table(name = "tb_pessoas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoasEntity implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected long id;

        protected String nome;
        protected String sobrenome;
        protected String cpf;
        protected String rg;
        protected String genero;
        protected String Perfis;
        protected String email;
        protected String contato;

        @JsonFormat(pattern = "yyyy-MM-dd")
        protected LocalDate dataNascimento;

        protected LocalDate dataCadastro = LocalDate.now();


        public void setPessoa(long id) {
        }


        public List<LoginEntity> perfis (LoginEntity perfil){
                List<LoginEntity> perfiList = new ArrayList<>();
                perfiList.add(perfil);
                return perfiList;
        }

        public void setPessoa_id(long id) {
        }
}


