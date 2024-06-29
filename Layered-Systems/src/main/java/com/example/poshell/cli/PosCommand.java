package com.example.poshell.cli;

import com.example.poshell.biz.PosService;
import com.example.poshell.model.Item;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class PosCommand {

    private PosService posService;

    private boolean cart_exit=false;

    @Autowired
    public void setPosService(PosService posService) 
    {
        this.posService = posService;
    }

    @ShellMethod(value = "List Products", key = "p")
    public String products() 
    {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Item item : posService.items()) {
            stringBuilder.append("\t").append(++i).append("\t").append(item).append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(value = "New Cart", key = "n")
    public String newCart() {
        cart_exit=true;
        return posService.newCart() + " OK";
    }

    @ShellMethodAvailability("availabilityCheck")
    @ShellMethod(value = "Add a Product to Cart", key = "a")
    public String addToCart(String productId, int amount) {
        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }

    @ShellMethodAvailability("availabilityCheck")
    @ShellMethod(value = "Remove a Product from Cart", key = "r")
    public String removeToCart(String productId, int amount) {
        if (posService.remove(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }
    @ShellMethodAvailability("availabilityCheck")
    @ShellMethod(value = "Display the Cart", key = "dis")
    public String display() {
            if(posService.getCart()!=null)
                return posService.getCart().toString();
            else
                return "No cart.";
    }
    @ShellMethodAvailability("availabilityCheck")
    @ShellMethod(value = "Empty the Cart", key = "e")
    public String empty_cart() 
    {
            posService.empty_cart();
            return posService.getCart().toString();
    }

    @ShellMethodAvailability("availabilityCheck")
    @ShellMethod(value = "checkout", key = "c")
    public String checkout() 
    {
            posService.getCart().toString();
            posService.getCart().empty();
            return "You have pay for the bill"; 
    }

    public Availability availabilityCheck() { 
        return cart_exit
            ? Availability.available()
            : Availability.unavailable("you have not create a cart!");
    }
}
