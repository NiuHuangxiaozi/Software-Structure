package com.example.webpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.webpos.biz.PosService;
import com.example.webpos.controller.api.SettingsApi;
import com.example.webpos.mapper.SettingMapper;
import com.example.webpos.model.Setting;
import com.example.webpos.model.dto.SettingDto;




@RestController
@CrossOrigin(originPatterns = "*")
public class SettingsController implements SettingsApi{
    
    private PosService posService;
    private SettingMapper settingMapper;

    
    @Autowired
    public void setPosService(PosService posService,SettingMapper settingMapper) {
        this.posService = posService;
        this.settingMapper=settingMapper;
    }

    @Override
    public ResponseEntity<List<SettingDto>> getSettings() {

        List<Setting> settings = posService.getSettings(); // 调用业务逻辑层获取所有产品
        if (settings == null || settings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有产品，返回无内容状态
        }
        System.out.println("get setting!");
        return new ResponseEntity<>(settingMapper.toSettingDtos(settings), HttpStatus.OK); // 返回DTO列表和HTTP状态OK
    }
}
