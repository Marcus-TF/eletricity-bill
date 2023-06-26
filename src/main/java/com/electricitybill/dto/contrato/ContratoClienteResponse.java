package com.electricitybill.dto.contrato;

import com.electricitybill.entity.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ContratoClienteResponse {

    private int id;

    private String descricao;

    private Date dataInicio;

    private Date dataFim;

    private int medidorId;

    private int classeId;

    private int tipoFase;

    private ClienteEntity clienteEntity;
}
