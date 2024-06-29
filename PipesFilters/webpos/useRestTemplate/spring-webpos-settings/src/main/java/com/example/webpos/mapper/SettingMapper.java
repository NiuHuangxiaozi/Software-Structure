package com.example.webpos.mapper;


import java.util.List;

import org.mapstruct.Mapper;

import com.example.webpos.model.Setting;
import com.example.webpos.model.dto.SettingDto;










@Mapper(componentModel = "spring")
public interface SettingMapper {

    SettingDto toSettingDto(Setting setting);

    Setting toSetting(SettingDto settingDto);

    List<Setting> toSettings(List<SettingDto> settingDtos);

    List<SettingDto> toSettingDtos(List<Setting> settings);
    
}
