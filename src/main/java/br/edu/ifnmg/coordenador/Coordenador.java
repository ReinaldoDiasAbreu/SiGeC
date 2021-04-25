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
package br.edu.ifnmg.coordenador;

import br.edu.ifnmg.curso.Curso;
import br.edu.ifnmg.sigec.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "tbl_coordenador")
public class Coordenador extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false)
    private String codigo;
    
    @Transient
    private ArrayList<Curso> cursosCriados;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Curso> getCursosCriados() {
        return cursosCriados;
    }

    public void setCursosCriados(ArrayList<Curso> cursosCriados) {
        this.cursosCriados = cursosCriados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordenador)) {
            return false;
        }
        Coordenador other = (Coordenador) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sigec.entity.Coordenador[ id=" + getId() + " ]";
    }
    
}
