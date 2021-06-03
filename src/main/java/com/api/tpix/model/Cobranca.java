package com.api.tpix.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_cobranca")
public class Cobranca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String txId;

    private Integer revisao;

    private String status;

    private String chave;

    private String solicitacaoPagador;

    private Double valor;

    private Boolean modalidadeAlteracao;

    @OneToMany(mappedBy = "cobranca", fetch = FetchType.LAZY)
    private List<InformacoesAdicionais> infoAdicionais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_devedor")
    private PessoaFisica devedor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calendario")
    private Calendario calendario;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Integer getRevisao() {
        return revisao;
    }

    public void setRevisao(Integer revisao) {
        this.revisao = revisao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public PessoaFisica getDevedor() {
        return devedor;
    }

    public void setDevedor(PessoaFisica devedor) {
        this.devedor = devedor;
    }

    public String getSolicitacaoPagador() {
        return solicitacaoPagador;
    }

    public void setSolicitacaoPagador(String solicitacaoPagador) {
        this.solicitacaoPagador = solicitacaoPagador;
    }

    public List<InformacoesAdicionais> getInfoAdicionais() {
        return infoAdicionais;
    }

    public void setInfoAdicionais(List<InformacoesAdicionais> infoAdicionais) {
        this.infoAdicionais = infoAdicionais;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getModalidadeAlteracao() {
        return modalidadeAlteracao;
    }

    public void setModalidadeAlteracao(Boolean modalidadeAlteracao) {
        this.modalidadeAlteracao = modalidadeAlteracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cobranca cobranca = (Cobranca) o;
        return Objects.equals(txId, cobranca.txId) && Objects.equals(revisao, cobranca.revisao) && Objects.equals(status, cobranca.status) && Objects.equals(chave, cobranca.chave) && Objects.equals(solicitacaoPagador, cobranca.solicitacaoPagador) && Objects.equals(devedor, cobranca.devedor) && Objects.equals(infoAdicionais, cobranca.infoAdicionais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(txId, revisao, status, chave, solicitacaoPagador, devedor, infoAdicionais);
    }
}
