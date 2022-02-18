package com.example.control.rest;

import com.example.model.*;
import com.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/MemberRest")
public class control_member_rest
{
        @Autowired
        private repo_member rmb;
 

        @RequestMapping(path="/MemberAll", method= RequestMethod.GET)
        public List<member> getMemberAll()
        {
          
            return (List)this.rmb.findAll();
        }

        @PostMapping("/MemberSave")
        @ResponseBody()
                public void savemember(@Valid member m)
        {
rmb.save(m);
        }

}


