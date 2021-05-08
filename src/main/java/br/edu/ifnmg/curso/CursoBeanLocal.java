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
package br.edu.ifnmg.curso;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alex
 */
@Local
public interface CursoBeanLocal {
    public void save(Curso c);
    public void delete(Curso c);
    public void update(Curso c);
    public List<Curso> findAllCursos();
    public Curso findCursoById(Long id);
    public List<Curso> findCursoByMinistrante(String ministrante);
    public List<Curso> findCursoByTitulo(String titulo);
    public List<Curso> findCursoByLocalizacao(String local);
    public List<Curso> findCursosConcluidos();
    public List<Curso> findCursosNaoConcluidos();
    public List<Curso> findCursosComVagas();
    public List<Curso> findAllOtherCoursesByEstudante(Long id);
}
