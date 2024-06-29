package com.example.webpos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.webpos.biz.PosService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }


    @GetMapping("/")
    public String pos(Model model) {
        posService.empty_cart();
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("products", posService.products());

        double subTotal =posService.total();
        double discount=posService.discount();
        double totalPrice=posService.realPrice();

        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice",totalPrice);
        return "index";
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "pid")String pid, Model model) {
        posService.add(pid, 1);
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("products", posService.products());
        
        double subTotal =posService.total();
        double discount=posService.discount();
        double totalPrice=posService.realPrice();

        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice",totalPrice);
        return "index";
    }

    @GetMapping("/removeCartitem")
    public String delete(@RequestParam(name = "pid")String pid,Model model) {
        posService.removeCartItem(pid);
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("products", posService.products());
        
        double subTotal =posService.total();
        double discount=posService.discount();
        double totalPrice=posService.realPrice();

        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice",totalPrice);
        return "index";
    }
    
    @GetMapping("/addnumber")
    public String addnumber(@RequestParam(name = "pid")String pid,Model model) {
        posService.add(pid, 1);
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("products", posService.products());
       
        double subTotal =posService.total();
        double discount=posService.discount();
        double totalPrice=posService.realPrice();

        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice",totalPrice);
        return "index";
    }


    @GetMapping("/subnumber")
    public String subnumber(@RequestParam(name = "pid")String pid,Model model) {
        posService.remove(pid, 1);
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("products", posService.products());

        double subTotal =posService.total();
        double discount=posService.discount();
        double totalPrice=posService.realPrice();

        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice",totalPrice);
        return "index";
    }

    @GetMapping("/charge")
    public String charge(Model model) {
        posService.empty_cart();
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("products", posService.products());
        double subTotal =posService.total();
        double discount=posService.discount();
        double totalPrice=posService.realPrice();

        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice",totalPrice);
        return "index";
    }

    @GetMapping("/emptyCart")
    public String emptyCart(Model model) {
        posService.empty_cart();
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("products", posService.products());
        double subTotal =posService.total();
        double discount=posService.discount();
        double totalPrice=posService.realPrice();

        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPrice",totalPrice);
        return "index";
    }
    
    
    
}
