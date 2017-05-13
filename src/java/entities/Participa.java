/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alan
 */
@Entity
@Table(name = "participa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participa.findAll", query = "SELECT p FROM Participa p"),
    @NamedQuery(name = "Participa.findByIdparticipa", query = "SELECT p FROM Participa p WHERE p.participaPK.idparticipa = :idparticipa"),
    @NamedQuery(name = "Participa.findByNifUser", query = "SELECT p FROM Participa p WHERE p.participaPK.nifUser = :nifUser"),
    @NamedQuery(name = "Participa.findByActSuscrito", query = "SELECT p FROM Participa p WHERE p.participaPK.actSuscrito = :actSuscrito"),
    @NamedQuery(name = "Participa.findByFecha", query = "SELECT p FROM Participa p WHERE p.fecha = :fecha")})
public class Participa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipaPK participaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "actSuscrito", referencedColumnName = "idactividad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividad actividad;
    @JoinColumn(name = "nifUser", referencedColumnName = "idnif", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Participa() {
    }

    public Participa(ParticipaPK participaPK) {
        this.participaPK = participaPK;
    }

    public Participa(ParticipaPK participaPK, Date fecha) {
        this.participaPK = participaPK;
        this.fecha = fecha;
    }

    public Participa(int idparticipa, String nifUser, int actSuscrito) {
        this.participaPK = new ParticipaPK(idparticipa, nifUser, actSuscrito);
    }

    public ParticipaPK getParticipaPK() {
        return participaPK;
    }

    public void setParticipaPK(ParticipaPK participaPK) {
        this.participaPK = participaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participaPK != null ? participaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participa)) {
            return false;
        }
        Participa other = (Participa) object;
        if ((this.participaPK == null && other.participaPK != null) || (this.participaPK != null && !this.participaPK.equals(other.participaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Participa[ participaPK=" + participaPK + " ]";
    }
    
}
