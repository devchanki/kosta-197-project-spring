package org.aptogether.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/keeper1/*")
public class FeeController {
   

   @GetMapping("/manager")
   public String managerDashBoard(){
      return "managerDashBoard";
   }
   
   @GetMapping("/feeRegister/{memberSeq}")
   public String feeRegister(@PathVariable("memberSeq") int memberSeq){
      
      return "feeRegister";
   }
   
}