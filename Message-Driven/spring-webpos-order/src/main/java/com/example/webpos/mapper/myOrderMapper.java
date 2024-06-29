package com.example.webpos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.example.webpos.model.myOrder;

import com.example.webpos.model.dto.MyOrderDto;





@Mapper(componentModel = "spring")
@Component
public interface myOrderMapper {

    myOrder tomyOrder(MyOrderDto myorderDto);

    MyOrderDto tomyOrderDto(myOrder myorder);

    List<myOrder> tomyOrderList(List<MyOrderDto> myorderDtos);

    List<MyOrderDto> tomyOrderDtoList(List<myOrder> category);
    
}
