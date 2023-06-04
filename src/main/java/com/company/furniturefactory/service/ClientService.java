package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.ClientDAO;
import com.company.furniturefactory.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientDAO clientDAO;

    public List<Client> getAll() {
        return clientDAO.getAll();
    }

    public void add(String name, String phone) {
        clientDAO.add(name, phone);
    }

    public void update(String name, String phone, Long id) {
        clientDAO.update(name,phone,id);
    }

    public void delete(Long id) {
        clientDAO.delete(id);
    }
}
