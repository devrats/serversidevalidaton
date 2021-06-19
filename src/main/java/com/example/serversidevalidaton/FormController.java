/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 6/19/2021
 *   Time: 5:01 AM
 *   File: FormController.java
 */

package com.example.serversidevalidaton;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class FormController {

    @RequestMapping("/form")
    public String form(Model model){
        model.addAttribute("person",new Person());
        return "form";
    }

    @RequestMapping("/submit")
    public String submit(@ModelAttribute @Valid Person person, BindingResult result, Model model){
        if(result.hasErrors()){
            return "form";
        }
        model.addAttribute("person",person);
        return "success";
    }
}