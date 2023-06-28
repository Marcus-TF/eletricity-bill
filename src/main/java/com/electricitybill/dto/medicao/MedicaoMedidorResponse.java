package com.electricitybill.dto.medicao;

import com.electricitybill.entity.TimeRotaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicaoMedidorResponse {

    private int id;

    private String mes;

    private String ano;

    private Date dataMedicao;

    private String consumo;

    private int medidorId;

    private TimeRotaEntity timeRotaEntity;
}
