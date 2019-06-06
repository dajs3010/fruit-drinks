package com.formos.juices.service;

import com.formos.juices.model.Portion;

public interface IInventoryService {

    void updateInventory(Portion portion, int used) throws Exception;

}
