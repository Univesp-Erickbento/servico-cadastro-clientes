package com.mypet.mypet.domain.model;

//import com.mypet.mypet.domain.model.Endereco;
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
@Table(name = "pessoas")
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
        protected LocalDate dataNascimento;
        protected LocalDate dataCadastro = LocalDate.now();


        public void setPessoa(long id) {
        }


        public List<PerfisEntity> perfis (PerfisEntity perfil){
                List<PerfisEntity> perfiList = new ArrayList<>();
                perfiList.add(perfil);
                return perfiList;
        }

        public void setPessoa_id(long id) {
        }
}


