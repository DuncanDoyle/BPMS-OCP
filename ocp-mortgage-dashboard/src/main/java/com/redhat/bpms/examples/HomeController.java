package com.redhat.bpms.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.server.api.model.definition.ProcessDefinition;
import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.api.model.instance.WorkItemInstance;

import com.redhat.bpms.examples.service.MgmtClientService;

/***
 * @author jary
 * @since Nov/03/2016
 */
@Path("/home")
@RequestScoped
public class HomeController {

    @Inject
    private MgmtClientService mgmtClientService;

    @GET
    @Path("/processes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcessDefinition> listProcesses() {
    	List<ProcessDefinition> returnList = new ArrayList<>();
    	ProcessDefinition definition = new ProcessDefinition();
    	
    	definition.setContainerId("containerId");
    	definition.setId("id");
    	definition.setName("Name");
    	definition.setPackageName("PackageName");
    	definition.setVersion("1.42");
    	returnList.add(definition);
    	return returnList;
    	
    	
    	
        //return mgmtClientService.listProcesses();
    }

    @GET
    @Path("/running")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcessInstance> listProcessInstances() {
    	
    	List<ProcessInstance> returnList = new ArrayList<>();
    	ProcessInstance instance = new ProcessInstance();
    	instance.setContainerId("bla");
    	instance.setDate(new Date());
    	instance.setId(42L);
    	instance.setProcessInstanceDescription("Description");
    	instance.setProcessName("ProcessName");
    	instance.setProcessVersion("1.42");
    	instance.setProcessId("ProcessId");
    	
    	returnList.add(instance);
    	
    	return returnList;
    	
    	//return mgmtClientService.listProcessInstances();
    }

    @GET
    @Path("/workitems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WorkItemInstance> listWorkItems() {

        return mgmtClientService.listWorkItems();
    }
}
