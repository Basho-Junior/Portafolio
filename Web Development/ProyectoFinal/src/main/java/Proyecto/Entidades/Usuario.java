package Proyecto.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Usuario.findAllByUsuario", query = "select u from Usuario u where u.usuario = :user"),
        @NamedQuery(name = "Usuario.autentificacion", query = "select u from Usuario u where u.usuario = :user and u.contrasenia = :pass")})
public class Usuario implements Serializable {
    public enum RoleasAPP
    {
        USUARIO, ADMIN
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @PrimaryKeyJoinColumn
    private String usuario;

    private String nombre;
    private String contrasenia;
    private RoleasAPP rol;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<Link> enlaces = new HashSet<Link>();

    public Usuario() {
    }

    public Usuario(int id, String usuario, String nombre, String contrasenia, RoleasAPP rol, Set<Link> enlaces) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.enlaces = enlaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public RoleasAPP getRol() {
        return rol;
    }

    public String getRole() {
        return rol.toString();
    }

    public void setRol(RoleasAPP rol) {
        this.rol = rol;
    }

    public Set<Link> getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(Set<Link> enlaces) {
        this.enlaces = enlaces;
    }
}
