package com.example.proyectofinal.models;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "USER_APP")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UserId")
    private int id;
    @ColumnInfo(name = "UserName")
    private String name;
    @ColumnInfo(name = "UserUname")
    private String username;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB, name = "UserPp")
    private byte[] pp;
    @ColumnInfo(name = "UserMail")
    private String mail;
    @ColumnInfo(name = "UserPassword")
    private String password;
    @ColumnInfo(name = "UserImage")
    private String image;

    public User() {
    }

    public User(String name, String username, byte[] pp, String mail, String password, String image) {
        this.name = name;
        this.username = username;
        this.pp = pp;
        this.mail = mail;
        this.password = password;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPp() {
        return pp;
    }

    public void setPp(byte[] pp) {
        this.pp = pp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
