package com.example.poshell.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        return items.add(item);
    }
    public void empty(){
        items.clear();
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getAmount() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }

    //add my code
    public boolean removeItem(String productId,int amount) 
    {
        for (Item p : items) {
            if(p.getProduct().getId().equals(productId)){
                if(p.getAmount()>amount){
                    p.setAmount(p.getAmount()-amount);
                    return true;
                }
                else if(p.getAmount()==amount)
                {
                    items.remove(p);
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }
}
