package com.example.control;

import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_member
{
   

    @RequestMapping(value={"/member"})
    public String member()
    {
        return "member/member";
    }

    @GetMapping({"/member"})
    public String member_form(Model model)
    {
        model.addAttribute("member", new member());
        return "member/member";
    }


}
