package com.controller.domain.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement
public class LinkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String HDDSN;
    private String CPUSN;
    private String IP;
    @Temporal(TemporalType.TIMESTAMP)
    private Date linkTime;

    public LinkLog() {
    }

    public LinkLog(String HDDSN, String CPUSN, String IP, Date linkTime) {
        this.HDDSN = HDDSN;
        this.CPUSN = CPUSN;
        this.IP = IP;
        this.linkTime = linkTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHDDSN() {
        return HDDSN;
    }

    public void setHDDSN(String HDDSN) {
        this.HDDSN = HDDSN;
    }

    public String getCPUSN() {
        return CPUSN;
    }

    public void setCPUSN(String CPUSN) {
        this.CPUSN = CPUSN;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Date getLinkTime() {
        return linkTime;
    }

    public void setLinkTime(Date linkTime) {
        this.linkTime = linkTime;
    }
}
