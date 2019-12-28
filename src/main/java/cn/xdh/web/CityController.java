package cn.xdh.web;

import cn.xdh.entity.City;
import cn.xdh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    StudentService studentService;

    @GetMapping("/province/{upId}")
    @ResponseBody
    public List<City> getCity(@PathVariable int upId){
        List<City> cityList = studentService.getCityByUpId(upId);
        return cityList;
    }

    @GetMapping("/city/{upId}")
    @ResponseBody
    public List<City> getArea(@PathVariable int upId){
        List<City> cityList = studentService.getAreaByUpId(upId);
        return cityList;
    }

}
