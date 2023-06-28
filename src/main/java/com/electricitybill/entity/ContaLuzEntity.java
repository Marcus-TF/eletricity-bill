package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContaLuzEntity {

    private int id;

    private int clienteId;

    private int medicaoId;

    private int cobrancaId;

    private int tarifaId;
}
