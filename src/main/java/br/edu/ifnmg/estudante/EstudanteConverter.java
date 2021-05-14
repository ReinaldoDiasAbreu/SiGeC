/*
 * Copyright (C) 2021 Mirrális
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
package br.edu.ifnmg.estudante;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Mirrális
 */

@FacesConverter(value = "estudanteConverter", managed = true)
@ApplicationScoped
public class EstudanteConverter implements Converter<Estudante>{
    
    @Inject
    private EstudanteBeanLocal estudanteLocal;

    @Override
    public Estudante getAsObject(
            FacesContext context, 
            UIComponent component, 
            String id) {
        if (id == null) {
            return null;
        }
        return estudanteLocal
                .findEstudanteById(Long.parseLong(id));
    }

    @Override
    public String getAsString(
            FacesContext context, 
            UIComponent component, 
            Estudante student) {
        if (student == null) {
            return null;
        }
        return student.getId().toString();
    }
    
}
