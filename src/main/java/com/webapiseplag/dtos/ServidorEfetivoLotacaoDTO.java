package com.webapiseplag.dtos;

import java.time.LocalDate;

public record ServidorEfetivoLotacaoDTO(
        String nome,
        Integer idade,
        String unidadeLotacao,
        String fotoBucket
) {}
