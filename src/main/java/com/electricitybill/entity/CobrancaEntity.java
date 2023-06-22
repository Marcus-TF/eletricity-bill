package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CobrancaEntity {

    private int id;

    private String mesReferencia;

    private String anoReferencia;

    private int tarifaId;

    private int medicaoId;
}
