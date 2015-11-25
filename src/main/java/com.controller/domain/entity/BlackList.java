package com.controller.domain.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hddsn;
    private String cpusn;
    private String ip;
    @Column(name="ip_sec")
    private String ipSec;

    public BlackList() {
    }

    public BlackList(String hddsn, String cpusn, String ip, String ipSec) {
        this.hddsn = hddsn;
        this.cpusn = cpusn;
        this.ip = ip;
        this.ipSec = ipSec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHddsn() {
        return hddsn;
    }

    public void setHddsn(String hddsn) {
        this.hddsn = hddsn;
    }

    public String getCpusn() {
        return cpusn;
    }

    public void setCpusn(String cpusn) {
        this.cpusn = cpusn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpSec() {
        return ipSec;
    }

    public void setIpSec(String ipSec) {
        this.ipSec = ipSec;
    }
}
