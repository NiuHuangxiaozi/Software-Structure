package com.example.webpos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.webpos.model.Delivery;
import com.example.webpos.model.dto.DeliveryDto;





@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    Delivery toDelivery(DeliveryDto myorderDto);

    DeliveryDto toDeliveryDto(Delivery myorder);

    List<Delivery> toDeliveryList(List<DeliveryDto> myorderDtos);

    List<DeliveryDto> toDeliveryDtoList(List<Delivery> category);
    
}
