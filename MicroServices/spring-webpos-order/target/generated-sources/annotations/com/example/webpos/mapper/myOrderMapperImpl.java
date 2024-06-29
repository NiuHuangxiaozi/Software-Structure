package com.example.webpos.mapper;

import com.example.webpos.model.dto.MyOrderDto;
import com.example.webpos.model.myOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T16:52:03+0800",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class myOrderMapperImpl implements myOrderMapper {

    @Override
    public myOrder tomyOrder(MyOrderDto myorderDto) {
        if ( myorderDto == null ) {
            return null;
        }

        myOrder myOrder = new myOrder();

        myOrder.setDescribe( myorderDto.getDescribe() );
        List<Integer> list = myorderDto.getGoods();
        if ( list != null ) {
            myOrder.setGoods( new ArrayList<Integer>( list ) );
        }
        myOrder.setOrderId( myorderDto.getOrderId() );
        if ( myorderDto.getPay() != null ) {
            myOrder.setPay( myorderDto.getPay() );
        }
        myOrder.setState( myorderDto.getState() );

        return myOrder;
    }

    @Override
    public MyOrderDto tomyOrderDto(myOrder myorder) {
        if ( myorder == null ) {
            return null;
        }

        MyOrderDto myOrderDto = new MyOrderDto();

        myOrderDto.setDescribe( myorder.getDescribe() );
        List<Integer> list = myorder.getGoods();
        if ( list != null ) {
            myOrderDto.setGoods( new ArrayList<Integer>( list ) );
        }
        myOrderDto.setOrderId( myorder.getOrderId() );
        myOrderDto.setPay( myorder.getPay() );
        myOrderDto.state( myorder.getState() );

        return myOrderDto;
    }

    @Override
    public List<myOrder> tomyOrderList(List<MyOrderDto> myorderDtos) {
        if ( myorderDtos == null ) {
            return null;
        }

        List<myOrder> list = new ArrayList<myOrder>( myorderDtos.size() );
        for ( MyOrderDto myOrderDto : myorderDtos ) {
            list.add( tomyOrder( myOrderDto ) );
        }

        return list;
    }

    @Override
    public List<MyOrderDto> tomyOrderDtoList(List<myOrder> category) {
        if ( category == null ) {
            return null;
        }

        List<MyOrderDto> list = new ArrayList<MyOrderDto>( category.size() );
        for ( myOrder myOrder : category ) {
            list.add( tomyOrderDto( myOrder ) );
        }

        return list;
    }
}
