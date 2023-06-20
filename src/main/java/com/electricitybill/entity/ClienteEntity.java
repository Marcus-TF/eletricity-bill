package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteEntity{


    private int id;

    private String numDocumento;

    private String numCliente;

    private int pessoaId;
}
