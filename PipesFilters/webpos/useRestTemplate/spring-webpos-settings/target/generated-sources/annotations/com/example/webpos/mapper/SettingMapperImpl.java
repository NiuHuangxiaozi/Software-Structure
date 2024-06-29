package com.example.webpos.mapper;

import com.example.webpos.model.Setting;
import com.example.webpos.model.dto.SettingDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T19:59:28+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.10 (Microsoft)"
)
@Component
public class SettingMapperImpl implements SettingMapper {

    @Override
    public SettingDto toSettingDto(Setting setting) {
        if ( setting == null ) {
            return null;
        }

        SettingDto settingDto = new SettingDto();

        settingDto.setSymbol( setting.getSymbol() );
        settingDto.setChargeTax( setting.getChargeTax() );
        settingDto.setPercentage( setting.getPercentage() );
        settingDto.setImg( setting.getImg() );
        settingDto.setStore( setting.getStore() );
        settingDto.setAddressOne( setting.getAddressOne() );
        settingDto.setAddressTwo( setting.getAddressTwo() );
        settingDto.setContact( setting.getContact() );
        settingDto.setFooter( setting.getFooter() );

        return settingDto;
    }

    @Override
    public Setting toSetting(SettingDto settingDto) {
        if ( settingDto == null ) {
            return null;
        }

        String symbol = null;
        Boolean chargeTax = null;
        int percentage = 0;
        String img = null;
        String store = null;
        String addressOne = null;
        String addressTwo = null;
        String contact = null;
        String footer = null;

        symbol = settingDto.getSymbol();
        chargeTax = settingDto.getChargeTax();
        if ( settingDto.getPercentage() != null ) {
            percentage = settingDto.getPercentage();
        }
        img = settingDto.getImg();
        store = settingDto.getStore();
        addressOne = settingDto.getAddressOne();
        addressTwo = settingDto.getAddressTwo();
        contact = settingDto.getContact();
        footer = settingDto.getFooter();

        Setting setting = new Setting( symbol, chargeTax, percentage, img, store, addressOne, addressTwo, contact, footer );

        return setting;
    }

    @Override
    public List<Setting> toSettings(List<SettingDto> settingDtos) {
        if ( settingDtos == null ) {
            return null;
        }

        List<Setting> list = new ArrayList<Setting>( settingDtos.size() );
        for ( SettingDto settingDto : settingDtos ) {
            list.add( toSetting( settingDto ) );
        }

        return list;
    }

    @Override
    public List<SettingDto> toSettingDtos(List<Setting> settings) {
        if ( settings == null ) {
            return null;
        }

        List<SettingDto> list = new ArrayList<SettingDto>( settings.size() );
        for ( Setting setting : settings ) {
            list.add( toSettingDto( setting ) );
        }

        return list;
    }
}
