/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.baco.restaurante.entities;

import co.edu.uniandes.baco.restaurante.entities.BaseEntity;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ISIS2603
 */
@Entity
public class RestauranteEntity extends BaseEntity implements Serializable {
   private Time hora_inicio_maniana;
   private Time hora_inicio_tarde;
   private Time hora_fin_maniana;
   private Time hora_fin_tarde;

    public List<SucursalEntity> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalEntity> sucursales) {
        this.sucursales = sucursales;
    }
   @PodamExclude
   @OneToMany
   private List<SucursalEntity> sucursales = new ArrayList<SucursalEntity>();


    public Time getHora_inicio_maniana() {
        return hora_inicio_maniana;
    }

    public void setHora_inicio_maniana(Time hora_inicio_maniana) {
        this.hora_inicio_maniana = hora_inicio_maniana;
    }

    public Time getHora_inicio_tarde() {
        return hora_inicio_tarde;
    }

    public void setHora_inicio_tarde(Time hora_inicio_tarde) {
        this.hora_inicio_tarde = hora_inicio_tarde;
    }

    public Time getHora_fin_maniana() {
        return hora_fin_maniana;
    }

    public void setHora_fin_maniana(Time hora_fin_maniana) {
        this.hora_fin_maniana = hora_fin_maniana;
    }

    public Time getHora_fin_tarde() {
        return hora_fin_tarde;
    }

    public void setHora_fin_tarde(Time hora_fin_tarde) {
        this.hora_fin_tarde = hora_fin_tarde;
    }
}
