package com.controller.api;

import com.controller.domain.entity.LinkLog;
import com.controller.domain.facade.LinkLogFacade;
import com.controller.domain.util.OnException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/link")
public class LinkLogResource {
    private LinkLogFacade linkLogFacade;
    @Inject
    public LinkLogResource(LinkLogFacade linkLogFacade) {
        this.linkLogFacade = linkLogFacade;
    }

    @GET
    @OnException("GetLinkLogFail")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LinkLog> getAllLinkLog(){
        return linkLogFacade.getAllLinkLogs();
    }

    @GET
    @Path("add/{ip}/{cpusn}/{hddsn}")
    @OnException("AddLinkLogFail")
    @Produces(MediaType.APPLICATION_JSON)
    public String addLinkLog(@PathParam("ip") String ip,@PathParam("cpusn") String cpusn,@PathParam("hddsn") String hddsn){
        return linkLogFacade.link(ip,cpusn,hddsn);
    }

}
