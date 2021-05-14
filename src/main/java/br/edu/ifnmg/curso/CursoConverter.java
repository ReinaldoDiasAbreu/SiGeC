/*
 * Copyright (C) 2021 Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
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
package br.edu.ifnmg.curso;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
 */
@FacesConverter(value = "cursoConverter", managed = true)
@ApplicationScoped
public class CursoConverter implements Converter <Curso>{
    
    @Inject
    private CursoBeanLocal cursoBean;

    @Override
    public Curso getAsObject(
            FacesContext context, 
            UIComponent component, 
            String id) {
        if (id == null) {
            return null;
        }
        return cursoBean.findCursoById(Long.parseLong(id));
    }

    @Override
    public String getAsString(
            FacesContext context, 
            UIComponent component, 
            Curso curso) {
        if (curso == null) {
            return null;
        }
        return curso.getId().toString();
    }
    
}
