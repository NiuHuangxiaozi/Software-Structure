package com.example.webpos.mapper;

import com.example.webpos.model.Delivery;
import com.example.webpos.model.dto.DeliveryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T09:59:26+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.10 (Microsoft)"
)
@Component
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public Delivery toDelivery(DeliveryDto myorderDto) {
        if ( myorderDto == null ) {
            return null;
        }

        Delivery delivery = new Delivery();

        delivery.setDeliveryId( myorderDto.getDeliveryId() );
        delivery.setOrderId( myorderDto.getOrderId() );
        delivery.setLogistics( myorderDto.getLogistics() );
        delivery.setDescribe( myorderDto.getDescribe() );

        return delivery;
    }

    @Override
    public DeliveryDto toDeliveryDto(Delivery myorder) {
        if ( myorder == null ) {
            return null;
        }

        DeliveryDto deliveryDto = new DeliveryDto();

        deliveryDto.setDeliveryId( myorder.getDeliveryId() );
        deliveryDto.setOrderId( myorder.getOrderId() );
        deliveryDto.setLogistics( myorder.getLogistics() );
        deliveryDto.setDescribe( myorder.getDescribe() );

        return deliveryDto;
    }

    @Override
    public List<Delivery> toDeliveryList(List<DeliveryDto> myorderDtos) {
        if ( myorderDtos == null ) {
            return null;
        }

        List<Delivery> list = new ArrayList<Delivery>( myorderDtos.size() );
        for ( DeliveryDto deliveryDto : myorderDtos ) {
            list.add( toDelivery( deliveryDto ) );
        }

        return list;
    }

    @Override
    public List<DeliveryDto> toDeliveryDtoList(List<Delivery> category) {
        if ( category == null ) {
            return null;
        }

        List<DeliveryDto> list = new ArrayList<DeliveryDto>( category.size() );
        for ( Delivery delivery : category ) {
            list.add( toDeliveryDto( delivery ) );
        }

        return list;
    }
}
