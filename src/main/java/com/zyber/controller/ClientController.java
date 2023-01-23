package com.zyber.controller;

import com.model.Client;
import com.zyber.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    //Retrieve client by first Name
    @RequestMapping(method = RequestMethod.GET,value="/client/search/{firstName}")
    public Client searchClientByFirstName(@Valid @PathVariable String firstName){
        return clientService.getClientByFirstName(firstName);
    }

    //Search client by ID
    @RequestMapping(method = RequestMethod.GET,value="/find/search/{id}")
    public Client searchClientById(@Valid @PathVariable String id){
        //Move this code to a service and method
        if (id.length() != 13) {
            System.out.println("Please enter a valid 13 character ID");

        }
        return clientService.getClientById(id);
    }

    //Search client by Phone Number
    @RequestMapping(method = RequestMethod.GET,value="/get/search/{phoneNumber}")
    public Client searchClientByPhoneNumber(@Valid @PathVariable String phoneNumber){
        return clientService.getClientByPhoneNumber(phoneNumber);
    }

    //Retrieve all clients
    @RequestMapping(method = RequestMethod.GET, value="/getAllClients")
    public List<Client> searchClient() {
        return clientService.getAllClients();
    }

    //Create client
    @RequestMapping(method = RequestMethod.POST,value = "/client")
    public void addClient(@Valid @RequestBody Client client){
        clientService.addClient(client);
    }

    //Update client
    @RequestMapping(method = RequestMethod.PUT,value = "/client/update/{id}")
    public void updateClient(@Valid @RequestBody Client client, @Valid @PathVariable String id){
        clientService.updateClient(id,client);
    }

}
