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
package br.edu.ifnmg.certificado;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alex
 */
@Local
public interface CertificadoBeanLocal {
    public void save(Certificado c);
    public void delete(Certificado c);
    public void update(Certificado c);
    public List<Certificado> findAll();
    public Certificado findById(Long id);
    public Certificado findByCodigo(String codigo);
}
