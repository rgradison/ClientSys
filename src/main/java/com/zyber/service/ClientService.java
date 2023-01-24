package com.zyber.service;

import com.model.Client;
import com.utils.IdNumberValidator;
import com.utils.MobileNumberValidator;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {
    private final IdNumberValidator idNumberValidator = new IdNumberValidator();
    private final MobileNumberValidator pNumberValidator= new MobileNumberValidator();

    private List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("Ralph", "King", "0763451234", "5901185800087", "91 Blairgowrie Dr"),
            new Client("Joshua", "Nigusi", "0834564156", "7101185800082", "153 The West End"),
            new Client("Koning", "Gradison", "0823562981", "8001185800083", "88 Bryanston Avenue"),
            new Client("Shadrack", "Seeps", "0827290846", "9201185800088", "60 Oxford"),
            new Client("Meshack", "George", "0824567890", "7208085992081", "91 Enterprise road")
    ));

    public List<Client> getAllClients() {
        return clients;
    }

    public Client getClientByFirstName(String firstName) {
        return clients.stream().filter(c -> c.getFirstName().equals(firstName)).findFirst().get();
    }

    public Client getClientById(String id) {
        if(!idNumberValidator.test(id)){
            throw new IllegalArgumentException("Invalid Id" + id + ": " + "Not valid.");
        }
        return clients.stream().filter(c -> c.getIdNumber().equals(id)).findFirst().get();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void updateClient(String id, Client client) {
        for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);
            if (c.getIdNumber().equals(id)) {
                clients.set(i, client);
                return;
            }
        }
    }

    public Client getClientByPhoneNumber(String phoneNumber) {
        if(!pNumberValidator.test(phoneNumber)){
            throw new IllegalArgumentException("Invalid Phone Number" + phoneNumber + ": " + "Not valid.");
        }
        return clients.stream().filter(c -> c.getMobileNumber().equals(phoneNumber)).findFirst().get();
    }

}

