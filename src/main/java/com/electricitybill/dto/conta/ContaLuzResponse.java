package com.electricitybill.dto.conta;

import com.electricitybill.entity.ClienteEntity;
import com.electricitybill.entity.CobrancaEntity;
import com.electricitybill.entity.MedicaoEntity;
import com.electricitybill.entity.TarifaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContaLuzResponse {

    private int id;

    private ClienteEntity clienteEntity;

    private MedicaoEntity medicaoEntity;

    private CobrancaEntity cobrancaEntity;

    private TarifaEntity tarifaEntity;
}
