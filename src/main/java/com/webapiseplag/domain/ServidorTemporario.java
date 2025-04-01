package com.webapiseplag.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "servidor_temporario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServidorTemporario {

    @Id
    @Column(name = "pes_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    @Column(name = "st_data_admissao")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(name = "st_data_demissao")
    @Temporal(TemporalType.DATE)
    private Date dataDemissao;
}