package com.cgi.user.controller;

import com.cgi.user.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/poc")
public class CallFlow {
    @Autowired RuntimeService runtimeService;



    @RequestMapping(value = "/startProcess",method = RequestMethod.POST)
    public void startProcess(@RequestBody Customer customer){

        System.out.print("calling flow");
        String customerInfo = "{\"name\":\"Sohail\",\"age\":\"31\"}";
        runtimeService.createMessageCorrelation("Start1").setVariable("customer",customerInfo).setVariable("uniqueID","123").correlate();
//        services.getIdentityService().createGroupQuery().orderByGroupName()
        //List<Task> tasks = taskService.createTaskQuery().taskAssignee("test2").list();
        //taskService.complete(taskId,map);
//        String json = "";
//        try {
//            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tasks);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(json);
    }
}
