package com.example.irrigation.service.dao;

import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.entity.Plot;

public interface AlertDao extends GenericCrudDao<Alert, Integer>{
    void deleteAll();

}