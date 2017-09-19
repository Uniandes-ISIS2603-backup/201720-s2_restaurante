/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author df.penap
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable {
    private boolean registrado;
    private boolean pagoAnticipado;
    private String tipo;
    public void setRegistrado(boolean registrado)
    {
        this.registrado = registrado;
    }
    public void setPagoAnticipado(boolean pagoAnticipado)
    {
        this.pagoAnticipado = pagoAnticipado;
    }
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    public boolean getRegistrado()
    {
        return registrado;
    }
    public boolean getPagoAnticipado()
    {
        return pagoAnticipado;
    }
    public String getTipo()
    {
        return tipo;
    }
    
}
