package com.controller.api;

import com.controller.domain.entity.BlackList;
import com.controller.domain.entity.LinkLog;
import com.controller.domain.facade.BlackListFacade;
import com.controller.domain.facade.LinkLogFacade;
import com.controller.domain.util.OnException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/black")
public class BlackListResource {
    private BlackListFacade blackListFacade;
    @Inject
    public BlackListResource(BlackListFacade blackListFacade) {
        this.blackListFacade = blackListFacade;
    }
    @GET
    @OnException("GetBlackListFail")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BlackList> getAllBlackList(){
        return blackListFacade.getAllBlackLists();
    }
    @GET
    @Path("verify/{ip}/{cpusn}/{hddsn}")
    @OnException("VerifyFail")
    @Produces(MediaType.APPLICATION_JSON)
    public String validate(@PathParam("ip") String ip,@PathParam("cpusn") String cpusn,@PathParam("hddsn") String hddsn){
        return blackListFacade.verify(ip,cpusn,hddsn);
    }

    @GET
    @Path("add/{ip}/{ipSec}/{cpusn}/{hddsn}")
    @OnException("AddBlackListFail")
    @Produces(MediaType.APPLICATION_JSON)
    public BlackList addLinkLog(@PathParam("ip") String ip,@PathParam("ipSec") String ipSec,@PathParam("cpusn") String cpusn,@PathParam("hddsn") String hddsn){
        return blackListFacade.add(ip,ipSec,cpusn,hddsn);
    }

}
