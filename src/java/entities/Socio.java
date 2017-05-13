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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alan
 */
@Entity
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
    @NamedQuery(name = "Socio.findByIdsocio", query = "SELECT s FROM Socio s WHERE s.idsocio = :idsocio"),
    @NamedQuery(name = "Socio.findByFechaBaja", query = "SELECT s FROM Socio s WHERE s.fechaBaja = :fechaBaja"),
    @NamedQuery(name = "Socio.findByCuota", query = "SELECT s FROM Socio s WHERE s.cuota = :cuota"),
    @NamedQuery(name = "Socio.findBySocioParticipa", query = "SELECT s FROM Socio s WHERE s.socioParticipa = :socioParticipa")})
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsocio")
    private Integer idsocio;
    @Column(name = "fechaBaja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota")
    private float cuota;
    @Size(max = 50)
    @Column(name = "socio_participa")
    private String socioParticipa;
    @JoinColumn(name = "idnifUsuarionif", referencedColumnName = "idnif")
    @ManyToOne(optional = false)
    private Usuario idnifUsuarionif;

    public Socio() {
    }

    public Socio(Integer idsocio) {
        this.idsocio = idsocio;
    }

    public Socio(Integer idsocio, float cuota) {
        this.idsocio = idsocio;
        this.cuota = cuota;
    }

    public Integer getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(Integer idsocio) {
        this.idsocio = idsocio;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    public String getSocioParticipa() {
        return socioParticipa;
    }

    public void setSocioParticipa(String socioParticipa) {
        this.socioParticipa = socioParticipa;
    }

    public Usuario getIdnifUsuarionif() {
        return idnifUsuarionif;
    }

    public void setIdnifUsuarionif(Usuario idnifUsuarionif) {
        this.idnifUsuarionif = idnifUsuarionif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsocio != null ? idsocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.idsocio == null && other.idsocio != null) || (this.idsocio != null && !this.idsocio.equals(other.idsocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Socio[ idsocio=" + idsocio + " ]";
    }
    
}
