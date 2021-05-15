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
package br.edu.ifnmg.estudante;

import br.edu.ifnmg.curso.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alex
 */
@Local
public interface EstudanteBeanLocal {
    public void save(Estudante e);
    public void delete(Estudante e);
    public void update(Estudante e);
    public List<Estudante> findAllEstudantes();
    public Estudante findEstudanteById(Long id);
    public Estudante findEstudanteByCpf(String cpf);
    public List<Curso> findCursosSolicitados(Long id);
    public List<Curso> findAllOtherCourses(Long id);
    public List<Curso> findCursosMatriculados(Long id);
}
