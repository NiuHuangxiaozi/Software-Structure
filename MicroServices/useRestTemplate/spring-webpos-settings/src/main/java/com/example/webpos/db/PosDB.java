package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.Setting;

public interface PosDB {
    //add in lab4
    public List<Setting> getSettings();
    
}