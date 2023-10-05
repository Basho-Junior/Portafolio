package com.example.practica11.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MockProyecto {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slb64")
    @GenericGenerator(name = "slb64", strategy = "com.example.practica11.utilidades.generadores.Base64SequenceGenerator", parameters = {
            @Parameter(name = "initial_value", value = "0")
//            @Parameter(name = "reserved_list_filename", value = "reserved"),
//            @Parameter(name = "reserved_case_sensitive", value = "true")
    })
    @Id
    @Column(length = 50)
    private String id;

    @OneToMany(mappedBy = "proyecto", orphanRemoval = true)
    private List<MockEndpoint> endpoints = new ArrayList<>();

    @Column(name = "usuario_id")
    private String usuarioId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MockEndpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<MockEndpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
