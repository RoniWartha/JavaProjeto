package com.webapiseplag.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid_id")
    private Long id;

    @Column(name = "cid_nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "cid_uf", length = 2, nullable = false)
    private String uf;

    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos;
}