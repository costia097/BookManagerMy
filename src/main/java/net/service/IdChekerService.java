package net.service;

import org.springframework.stereotype.Component;

@Component
public class IdChekerService {
    private  int id = 1;
    public  int addId() {
        return id++;
    }
}
