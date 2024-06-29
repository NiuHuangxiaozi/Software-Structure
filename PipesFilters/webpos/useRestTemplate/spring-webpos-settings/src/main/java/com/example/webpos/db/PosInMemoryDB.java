package com.example.webpos.db;
import com.example.webpos.model.Setting;


import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class PosInMemoryDB implements PosDB {
    
    @Autowired
    private List<Setting> Settings;


    @PostConstruct
    public void init(){
         //添加shop信息
         this.Settings.set(0,new Setting("$", true, 30,"settings.jpg", "教育超市", "上海市静安区教育大厦", "美国弗吉尼亚","15190785634","版权所有"));
    }

    ///////////////////////////////////////////////////////////
    //add in lab4 
    public List<Setting> getSettings(){
        return this.Settings;
    }
}
