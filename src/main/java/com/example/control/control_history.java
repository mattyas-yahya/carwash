package com.example.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_history
{
    @RequestMapping(value={"/histori"})
    public String x() {
        return "histori/histori";
    }

    @RequestMapping(value={"/histori_cost"})
    public String z() {
        return "histori/histori_cost";
    }

    @RequestMapping(value={"/histori_jadwal"})
  public String y() {
    return "histori/histori_jadwal";
  }

  @RequestMapping(value={"/dummy"})
  public String a() {
    return "histori/dummy";
  }

  @RequestMapping(value={"/downtime"})
  public String b() {
    return "histori/downtime";
  }

  @RequestMapping(value={"/costbydate"})
  public String c() {
    return "histori/costbydate";
  }

  @RequestMapping(value={"/users"})
  public String xd() {
    return "users/users";
  }
}
