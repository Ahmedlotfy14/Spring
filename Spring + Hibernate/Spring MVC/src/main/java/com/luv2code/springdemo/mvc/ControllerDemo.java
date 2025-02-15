package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller()
public class ControllerDemo {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

   @GetMapping("/")
    public String showForm(Model myModel){
       myModel.addAttribute("customer",new Customer());

       return "customer-form";
   }

   @PostMapping("/processForm")
      String processForm(

           @Valid@ModelAttribute("customer") Customer myCustomer , BindingResult theBindingResult
           ){
            System.out.println("last name : " + "|" +myCustomer.getLastName()+"|");
            if (theBindingResult.hasErrors()){
                return "customer-form";
            }
            else {
                return "customer-confirmation";
            }
   }
}

