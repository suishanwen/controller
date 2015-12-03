package com.controller.domain.facade;

import com.controller.domain.entity.LinkLog;
import com.google.inject.persist.Transactional;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;


public class LinkLogFacade extends BaseFacade{

    @Transactional
    public String link(String ip,String cpusn,String hddsn,String controllerVersion,String handlerVersion){
        String val=validate(controllerVersion, handlerVersion);
        if(Integer.parseInt(val)>=0){
            return val;
        }
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

    public String validate(String controllerVersion,String handlerVersion){
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("/home/config.properties");
            prop.load(fis);
            fis.close();
        }catch (Exception e){
            return "0";
        }
        if(!prop.getProperty("controllerVersion").equals(controllerVersion)&&!prop.getProperty("handlerVersion").equals(handlerVersion)){
            return "3";
        }else if(!prop.getProperty("handlerVersion").equals(handlerVersion)){
            return "2";
        } else if(!prop.getProperty("controllerVersion").equals(controllerVersion)){
            return "1";
        }else {
            return "-1";
        }

    }

}
