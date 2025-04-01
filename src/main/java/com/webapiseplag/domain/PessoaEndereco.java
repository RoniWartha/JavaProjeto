package com.webapiseplag.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "pessoa_endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaEndereco {

    @EmbeddedId
    private PessoaEnderecoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pessoaId")
    @JoinColumn(name = "pes_id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("enderecoId")
    @JoinColumn(name = "end_id", nullable = false)
    private Endereco endereco;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class PessoaEnderecoId implements Serializable {
        private Long pessoaId;
        private Long enderecoId;
    }
}