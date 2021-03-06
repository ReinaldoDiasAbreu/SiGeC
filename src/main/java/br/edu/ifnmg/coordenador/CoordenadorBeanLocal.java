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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alex
 */
@Local
public interface CoordenadorBeanLocal {
    public void save(Coordenador c);
    public void delete(Coordenador c);
    public void update(Coordenador c);
    public List<Coordenador> findAllCoordenadores();
    public Coordenador findCoordenadorById(Long id);
    public Coordenador findCoordenadorByCodigo(String cod);
    public List<Curso> findCursosCriados(Long id);
}
