package com.example.examen_jpa_cascada.service;

import com.example.examen_jpa_cascada.entity.Cliente;
import com.example.examen_jpa_cascada.repository.ClienteRepo;
import com.example.examen_jpa_cascada.service.impl.FacturaService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DataLoader implements InitializingBean {

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private FacturaService facturaService;

    @Override
    public void afterPropertiesSet() {
        Cliente nuevoCliente = new Cliente(0L, "Adi");

        Cliente clienteGuardado = clienteRepo.save(nuevoCliente);

        facturaService.insertarFacturaDePrueba(clienteGuardado);
    }
}
