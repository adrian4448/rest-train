package com.api.tpix.dto;

import java.util.List;

public class CobrancaDTO {

    private CalendarioDTO calendario;
    private PessoaFisicaDTO devedor;
    private ValorDTO valor;
    private String chave;
    private String txId;
    private String solicitacaoPagador;

    private List<InfoAdicionaisDTO> infoAdicionais;

    public PessoaFisicaDTO getDevedor() {
        return devedor;
    }

    public void setDevedor(PessoaFisicaDTO devedor) {
        this.devedor = devedor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getSolicitacaoPagador() {
        return solicitacaoPagador;
    }

    public void setSolicitacaoPagador(String solicitacaoPagador) {
        this.solicitacaoPagador = solicitacaoPagador;
    }

    public List<InfoAdicionaisDTO> getInfoAdicionais() {
        return infoAdicionais;
    }

    public void setInfoAdicionais(List<InfoAdicionaisDTO> infoAdicionais) {
        this.infoAdicionais = infoAdicionais;
    }

    public CalendarioDTO getCalendario() {
        return calendario;
    }

    public void setCalendario(CalendarioDTO calendario) {
        this.calendario = calendario;
    }

    public ValorDTO getValor() {
        return valor;
    }

    public void setValor(ValorDTO valor) {
        this.valor = valor;
    }
}
