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
package br.edu.ifnmg.pessoa;

import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
 */
@Local
public interface PessoaBeanLocal {
    public List<Pessoa> findAllPessoas();
    public Pessoa findPessoaById(Long id);
    public List<Pessoa> findPessoaByNome(String nome);
    public Optional < Pessoa >  findPessoaByEmail(String email);
    public Optional < String >  findGrupoPessoa(String email);
}
