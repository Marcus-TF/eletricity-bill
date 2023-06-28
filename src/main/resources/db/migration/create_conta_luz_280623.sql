CREATE TABLE public.conta_luz
(
    id          serial NOT NULL,
    cliente_id  int    NULL,
    medicao_id  int    NULL,
    cobranca_id int    NULL,
    tarifa_id   int    NULL,

    CONSTRAINT conta_luz_pkey PRIMARY KEY (id)
);
ALTER TABLE public.conta_luz
    ADD CONSTRAINT conta_luz_cliente_id_fkey FOREIGN KEY (cliente_id) REFERENCES public.cliente (id);
ALTER TABLE public.conta_luz
    ADD CONSTRAINT conta_luz_medicao_id_fkey FOREIGN KEY (medicao_id) REFERENCES public.medicao (id);
ALTER TABLE public.conta_luz
    ADD CONSTRAINT conta_luz_cobranca_id_fkey FOREIGN KEY (cobranca_id) REFERENCES public.cobranca (id);
ALTER TABLE public.conta_luz
    ADD CONSTRAINT conta_luz_tarifa_id_fkey FOREIGN KEY (tarifa_id) REFERENCES public.tarifa (id);