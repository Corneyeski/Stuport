/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alan
 */
@Embeddable
public class ParticipaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idparticipa")
    private int idparticipa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nifUser")
    private String nifUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actSuscrito")
    private int actSuscrito;

    public ParticipaPK() {
    }

    public ParticipaPK(int idparticipa, String nifUser, int actSuscrito) {
        this.idparticipa = idparticipa;
        this.nifUser = nifUser;
        this.actSuscrito = actSuscrito;
    }

    public int getIdparticipa() {
        return idparticipa;
    }

    public void setIdparticipa(int idparticipa) {
        this.idparticipa = idparticipa;
    }

    public String getNifUser() {
        return nifUser;
    }

    public void setNifUser(String nifUser) {
        this.nifUser = nifUser;
    }

    public int getActSuscrito() {
        return actSuscrito;
    }

    public void setActSuscrito(int actSuscrito) {
        this.actSuscrito = actSuscrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idparticipa;
        hash += (nifUser != null ? nifUser.hashCode() : 0);
        hash += (int) actSuscrito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipaPK)) {
            return false;
        }
        ParticipaPK other = (ParticipaPK) object;
        if (this.idparticipa != other.idparticipa) {
            return false;
        }
        if ((this.nifUser == null && other.nifUser != null) || (this.nifUser != null && !this.nifUser.equals(other.nifUser))) {
            return false;
        }
        if (this.actSuscrito != other.actSuscrito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ParticipaPK[ idparticipa=" + idparticipa + ", nifUser=" + nifUser + ", actSuscrito=" + actSuscrito + " ]";
    }
    
}
