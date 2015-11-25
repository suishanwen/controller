package com.controller.domain.facade;


import com.controller.domain.entity.BlackList;
import com.google.inject.persist.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.List;

public class BlackListFacade extends BaseFacade{

    public String verify(String ip,String hddsn,String cpusn){
        if(ip.split("\\.").length!=4){
            return "no";
        }
        String ipSec=ip.split("\\.")[0]+"."+ip.split("\\.")[1];
        try {
            entityManager.createQuery("select bl from BlackList bl where bl.ip=:ip or bl.hddsn=:hddsn or bl.cpusn=:cpusn or bl.ipSec=:ipSec")
                    .setParameter("ip",ip)
                    .setParameter("hddsn",hddsn)
                    .setParameter("cpusn",cpusn)
                    .setParameter("ipSec",ipSec)
                    .getSingleResult();
            return "no";
        }
        catch (NoResultException e){
            return "ok";
        }catch (NonUniqueResultException e){
            return "no";
        }
    }

    public List<BlackList> getAllBlackLists(){
        return entityManager.createQuery("select bl from BlackList bl").getResultList();
    }

    @Transactional
    public BlackList add(String ip,String ipSec,String hddsn,String cpusn){
        BlackList bl=new BlackList();
        bl.setIp(ip);
        bl.setIpSec(ipSec);
        bl.setHddsn(hddsn);
        bl.setCpusn(cpusn);
        try {
            entityManager.persist(bl);
            return bl;
        }catch (NoResultException e){
            return null;
        }
    }
}
