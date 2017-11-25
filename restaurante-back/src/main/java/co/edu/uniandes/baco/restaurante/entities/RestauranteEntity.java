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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ISIS2603
 */
@Entity
public class RestauranteEntity extends BaseEntity implements Serializable {

    @Temporal(TemporalType.DATE)
    private Date horaInicioManiana;
    @Temporal(TemporalType.DATE)
    private Date horaInicioTarde;
    @Temporal(TemporalType.DATE)
    private Date horaFinManiana;
    @Temporal(TemporalType.DATE)
    private Date horaFinTarde;

    @PodamExclude
    @OneToMany
    private List<SucursalEntity> sucursales = new ArrayList<>();
    @PodamExclude
    @OneToMany
    private List<ClienteEntity> clientes = new ArrayList<>();
    @PodamExclude
    @OneToMany
    private List<TarjetaPuntosEntity> tarjetas = new ArrayList<>();
    @PodamExclude
    @OneToMany
    private List<PlatoEntity> platos = new ArrayList<>();
    @PodamExclude
    @OneToMany
    private List<ReservaEntity> reservas = new ArrayList<>();
    @PodamExclude
    @OneToMany
    private List<DomicilioEntity> domicilios = new ArrayList<>();

    public List<SucursalEntity> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalEntity> sucursales) {
        this.sucursales = sucursales;
    }

    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteEntity> clientes) {
        this.clientes = clientes;
    }

    public List<TarjetaPuntosEntity> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<TarjetaPuntosEntity> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public List<PlatoEntity> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PlatoEntity> platos) {
        this.platos = platos;
    }

    public List<DomicilioEntity> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<DomicilioEntity> domicilios) {
        this.domicilios = domicilios;
    }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }

    public Date getHoraInicioManiana() {
        return horaInicioManiana;
    }

    public void setHoraInicioManiana(Date horaInicioManiana) {
        this.horaInicioManiana = horaInicioManiana;
    }

    public Date getHoraInicioTarde() {
        return horaInicioTarde;
    }

    public void setHoraInicioTarde(Date horaInicioTarde) {
        this.horaInicioTarde = horaInicioTarde;
    }

    public Date getHoraFinManiana() {
        return horaFinManiana;
    }

    public void setHoraFinManiana(Date horaFinManiana) {
        this.horaFinManiana = horaFinManiana;
    }

    public Date getHoraFinTarde() {
        return horaFinTarde;
    }

    public void setHoraFinTarde(Date horaFinTarde) {
        this.horaFinTarde = horaFinTarde;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
}
