package com.example.irrigation.service.impl;

import com.example.irrigation.service.AlertService;
import com.example.irrigation.service.PlotService;
import com.example.irrigation.service.dao.AlertDao;
import com.example.irrigation.service.dao.PlotDao;
import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {
    @Autowired
    private final AlertDao alertDao;

    @Override
    public Alert addAlert(Alert alert) {
        return alertDao.save(alert);
    }

    @Override
    public List<Alert> getAllAlerts() {
        return alertDao.findAll();
    }

    @Override
    public Alert getAlertById(Integer id) {
        return alertDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("plot with id " + id + ",not found"));
    }

    @Override
    public void deleteAll() {
        alertDao.deleteAll();
    }
}
