package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClasseEntity {

    private int id;

    private String descricao;

    private int tipoFaseId;
}
