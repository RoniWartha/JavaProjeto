package com.webapiseplag.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "lotacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pes_id", nullable = false)
    private ServidorEfetivo servidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unid_id", nullable = false)
    private Unidade unidade;

    @Column(name = "lot_data_lotacao")
    @Temporal(TemporalType.DATE)
    private Date dataLotacao;

    @Column(name = "lot_data_remocao")
    @Temporal(TemporalType.DATE)
    private Date dataRemocao;

    @Column(name = "lot_portaria", length = 100)
    private String portaria;
}