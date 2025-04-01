package com.webapiseplag.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "unidade_endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadeEndereco {

    @EmbeddedId
    private UnidadeEnderecoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("unidadeId")
    @JoinColumn(name = "unid_id", nullable = false)
    private Unidade unidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("enderecoId")
    @JoinColumn(name = "end_id", nullable = false)
    private Endereco endereco;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class UnidadeEnderecoId implements Serializable {
        private Long unidadeId;
        private Long enderecoId;
    }
}