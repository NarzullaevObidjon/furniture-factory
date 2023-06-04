package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.ClientDAO;
import com.company.furniturefactory.dao.SupplierDAO;
import com.company.furniturefactory.domain.Client;
import com.company.furniturefactory.domain.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierDAO supplierDAO;

    public List<Supplier> getAll() {
        return supplierDAO.getAll();
    }

    public void add(String name, String phone) {
        supplierDAO.add(name, phone);
    }

    public void update(String name, String phone, Long id) {
        supplierDAO.update(name,phone,id);
    }

    public void delete(Long id) {
        supplierDAO.delete(id);
    }
}
