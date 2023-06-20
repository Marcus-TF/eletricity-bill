package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioEntity {

    private int id;

    private String codigoFuncional;

    private int pessoaId;
}
