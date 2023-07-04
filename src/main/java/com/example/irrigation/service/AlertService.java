package com.example.irrigation.service;

import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.entity.Plot;

import java.util.List;

public interface AlertService {
    public Alert addAlert(Alert alert);
    public List<Alert> getAllAlerts();
    public Alert getAlertById(Integer id);
    public void deleteAll();
}
