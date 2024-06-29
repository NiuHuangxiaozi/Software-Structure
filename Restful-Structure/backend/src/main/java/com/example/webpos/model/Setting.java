package com.example.webpos.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;








@Data
@AllArgsConstructor
@Component
public class Setting {
    
        private String symbol;

        private Boolean chargeTax;

        private int percentage;

        private String img;

        private String store;

        private String addressOne;

        private String addressTwo;

        private String contact;

        private String footer;

        Setting(){
                
        }
}
