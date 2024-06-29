package com.example.webpos.mapper;

import com.example.webpos.model.Setting;
import com.example.webpos.model.dto.SettingDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T08:37:39+0800",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class SettingMapperImpl implements SettingMapper {

    @Override
    public SettingDto toSettingDto(Setting setting) {
        if ( setting == null ) {
            return null;
        }

        SettingDto settingDto = new SettingDto();

        settingDto.setAddressOne( setting.getAddressOne() );
        settingDto.setAddressTwo( setting.getAddressTwo() );
        settingDto.setChargeTax( setting.getChargeTax() );
        settingDto.setContact( setting.getContact() );
        settingDto.setFooter( setting.getFooter() );
        settingDto.setImg( setting.getImg() );
        settingDto.setPercentage( setting.getPercentage() );
        settingDto.store( setting.getStore() );
        settingDto.symbol( setting.getSymbol() );

        return settingDto;
    }

    @Override
    public Setting toSetting(SettingDto settingDto) {
        if ( settingDto == null ) {
            return null;
        }

        String addressOne = null;
        String addressTwo = null;
        Boolean chargeTax = null;
        String contact = null;
        String footer = null;
        String img = null;
        int percentage = 0;
        String store = null;
        String symbol = null;

        addressOne = settingDto.getAddressOne();
        addressTwo = settingDto.getAddressTwo();
        chargeTax = settingDto.getChargeTax();
        contact = settingDto.getContact();
        footer = settingDto.getFooter();
        img = settingDto.getImg();
        if ( settingDto.getPercentage() != null ) {
            percentage = settingDto.getPercentage();
        }
        store = settingDto.getStore();
        symbol = settingDto.getSymbol();

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
