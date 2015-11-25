package com.controller.domain.facade;

import com.controller.domain.entity.LinkLog;
import com.google.inject.persist.Transactional;

import java.util.Date;
import java.util.List;


public class LinkLogFacade extends BaseFacade{

    @Transactional
    public String link(String ip,String cpusn,String hddsn){
        LinkLog l=new LinkLog();
        l.setIP(ip);
        l.setCPUSN(cpusn);
        l.setHDDSN(hddsn);
        l.setLinkTime(new Date());
        try {
            entityManager.persist(l);
            return "success";
        }catch (Exception e){
            return "fail";
        }
    }

    public List<LinkLog> getAllLinkLogs(){
        return entityManager.createQuery("select l from LinkLog l").getResultList();
    }

}
