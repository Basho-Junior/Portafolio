package com.example.webapp.utilities;

import com.example.webapp.utilities.enumerate.OrdenStatus;

import java.math.BigDecimal;
import java.util.Date;


public class Orden {
    private Long id;
    private String paypal_order_id;
    private OrdenStatus status;
    private String clientUsername;
    private Date createDate;
    private Date updateDate;
    private Date dueDate;
    private Servicio servicio;
    private BigDecimal total;

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
}
