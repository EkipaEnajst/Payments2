package org.ekipaenajst.entitete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="parkirnina")
@NamedQueries(value = {
        @NamedQuery(name = "Parkirnina.findId", query="SELECT p from Parkirnina p WHERE p.id= :idParam"),
        @NamedQuery(name = "Parkirnina.findAvto", query="SELECT p from Parkirnina p WHERE p.avtoId= :avtoParam ORDER BY p.konec DESC"),
        @NamedQuery(name = "Parkirnina.findUser", query="SELECT p from Parkirnina p WHERE p.uporabnikId= :userParam ORDER BY p.konec DESC"),
})
public class Parkirnina implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int uporabnikId;

    private int avtoId;

    private LocalDateTime zacetek;

    private LocalDateTime konec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUporabnikId() {
        return uporabnikId;
    }

    public void setUporabnikId(int uporabnikId) {
        this.uporabnikId = uporabnikId;
    }

    public int getAvtoId() {
        return avtoId;
    }

    public void setAvtoId(int avtoId) {
        this.avtoId = avtoId;
    }

    public LocalDateTime getZacetek() {
        return zacetek;
    }

    public void setZacetek(LocalDateTime zacetek) {
        this.zacetek = zacetek;
    }

    public LocalDateTime getKonec() {
        return konec;
    }

    public void setKonec(LocalDateTime konec) {
        this.konec = konec;
    }
}
