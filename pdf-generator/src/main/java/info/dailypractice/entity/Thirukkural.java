package info.dailypractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Thirukkural {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int kural_id;
    private String line1;
    private String line2;

    public Thirukkural() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKural_id() {
        return kural_id;
    }

    public void setKural_id(int kural_id) {
        this.kural_id = kural_id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    @Override
    public String toString() {
        return "Thirukkural{" +
                "id=" + id +
                ", kural_id=" + kural_id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thirukkural that = (Thirukkural) o;
        return kural_id == that.kural_id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(kural_id);
    }
}
