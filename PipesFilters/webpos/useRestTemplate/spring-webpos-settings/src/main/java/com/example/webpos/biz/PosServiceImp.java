package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;





@Service
@Component
public class PosServiceImp implements PosService {

    private PosDB posDB;

    @Autowired
    public void setPosDB(PosDB posDB) {
        this.posDB = posDB;
    }
    
    //add in lab4
    public List<Setting> getSettings(){
        return this.posDB.getSettings();
    }
}