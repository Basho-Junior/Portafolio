package com.example.practica11.entidades;

import com.example.practica11.entidades.composite.MockEndpointPK;
import com.example.practica11.utilidades.MockEndpointMethods;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

@Entity
@IdClass(MockEndpointPK.class)
public class MockEndpoint {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slb64_2")
//    @GenericGenerator(name = "slb64_2", strategy = "com.example.practica11.utilidades.generadores.Base64SequenceGenerator", parameters = {
//            @Parameter(name = "initial_value", value = "0")
////            @Parameter(name = "reserved_list_filename", value = "reserved"),
////            @Parameter(name = "reserved_case_sensitive", value = "true")
//    })
//    @Id
//    private String id;
    @Id
    @Column(name = "proyecto_id", length = 50)
    private String proyectoId;

    @Id
    @Column
    private String path;

    @Id
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private MockEndpointMethods method;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "proyecto_id", insertable = false, updatable = false)
    private MockProyecto proyecto;


    @ElementCollection
    @Column(length=32)
    private Map<String, String> headers;
    @Column
    private String contentType;
    @Column
    private int httpCode;
    @Column
    private String body;
    @Basic
    private int sendTime;
    @Basic
    private Timestamp expiration;
    @Column
    private String name;
    @Column
    private String description;

    @Column(length = 512)
    private String jwtToken;
    @Basic
    private Boolean jwtRequired;


    public MockEndpoint() {

    }

    public MockEndpoint(MockProyecto proyecto,String proyectoId, String path) {
        this.proyecto = proyecto;
        this.proyectoId = proyectoId;
        this.path = path;
    }

    public MockEndpoint(MockEndpointPK pk) {
        this.proyectoId = pk.getProyectoId();
        this.path = pk.getPath();
        this.method = pk.getMethod();
    }

    public MockProyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(MockProyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MockEndpointMethods getMethod() {
        return method;
    }

    public void setMethod(MockEndpointMethods method) {
        this.method = method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getRootPath() {
        return "/mock/"+proyectoId+path;
    }

    public Boolean getJwtRequired() {
        return jwtRequired;
    }

    public void setJwtRequired(Boolean jwtRequired) {
        this.jwtRequired = jwtRequired;
    }

    public Boolean isExpired() {
        return this.expiration.before(Timestamp.from(Instant.now()));
    }

    public String getRemainingTimeAsString() {
        Duration duration = Duration.between(Instant.now(),expiration.toInstant());
        return String.format("%d %02d:%02d:%02d", duration.toDaysPart(), duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());
    }
    public int getSendTime() {
        return sendTime;
    }
    public void setSendTime(int sendTime) {
        this.sendTime = sendTime;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
