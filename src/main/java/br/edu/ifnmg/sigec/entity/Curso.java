/*
 * Copyright (C) 2021 alex
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.edu.ifnmg.sigec.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author alex
 */
@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private String local;
    
    @Column(nullable = false)
    private int cargaHoraria;
    
    @Column(nullable = false)
    private int vagas;
    
    @Column(nullable = false)
    private String ministrante;
    
    @Column(nullable = false)
    private boolean concluido;
    
    @OneToOne
    private Coordenador criador;
    
    @ManyToMany(mappedBy = "estudante")
    @Transient
    private ArrayList<Estudante> matriculados;
    
    @ManyToMany(mappedBy = "estudante")
    @Transient
    private ArrayList<Estudante> solicitantes;

    public Coordenador getCriador() {
        return criador;
    }

    public void setCriador(Coordenador criador) {
        this.criador = criador;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public ArrayList<Estudante> getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(ArrayList<Estudante> matriculados) {
        this.matriculados = matriculados;
    }

    public ArrayList<Estudante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(ArrayList<Estudante> solicitantes) {
        this.solicitantes = solicitantes;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sigec.entity.Curso[ id=" + id + " ]";
    }
    
}
