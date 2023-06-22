package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeRotaEntity {

    private int id;

    private int funcionarioId;

    private int tarefaRotaId;
}
