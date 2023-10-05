package Parcial2.encapsulaciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/**
 * Objeto con estructura POJO.
 */
@Entity
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int matricula;
    private String nombre;
    private String sector;

    private String nivel;

    @Column(columnDefinition = "boolean default true")
    private boolean estado;


    public Estudiante() {
    }

    public Estudiante(int matricula, String nombre, String sector, String nivel) {
        this.matricula = matricula;
        this.nombre = nombre;
        estado = true;
        this.sector = sector;
        this.nivel = nivel;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void mezclar(Estudiante e){
        matricula = e.getMatricula();
        nombre = e.getNombre();
        sector = e.getSector();
        nivel = e.getNivel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return matricula == that.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
