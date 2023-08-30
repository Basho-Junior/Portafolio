package com.example.basecompra.models;

import com.example.basecompra.models.enumerate.OrdenStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Orden {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String paypal_order_id;

    @Enumerated(EnumType.ORDINAL)
    private OrdenStatus status;

    //para el usuario??
    private String clientUsername;

    private Date createDate;

    private Date acceptedDate;

    private Date updateDate;

    private Date dueDate;

    @ManyToOne
    private Servicio servicio;

    private BigDecimal total;

    public Orden() {
    }

    public Orden(String paypal_order_id, Date dueDate, String clientUsername, Servicio servicio, BigDecimal total) {
        this.createDate = new Date();
        this.updateDate = this.createDate;
        this.paypal_order_id = paypal_order_id;
        this.dueDate = dueDate;
        this.status = OrdenStatus.CREATED;
        this.clientUsername = clientUsername;
        this.servicio = servicio;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaypal_order_id() {
        return paypal_order_id;
    }

    public void setPaypal_order_id(String paypal_order_id) {
        this.paypal_order_id = paypal_order_id;
    }

    public OrdenStatus getStatus() {
        return status;
    }

    public void setStatus(OrdenStatus status) {
        this.status = status;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }
}
