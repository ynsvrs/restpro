package kz.aitu.restpro2423.restpro.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aitu.restpro2423.restpro.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kz.aitu.restpro2423.restpro.entities.*;

@RestController
public class MyController {
    @Autowired
    private ObjectMapper obMapper;

    @GetMapping("/hello")
    public String myHelloListener(){
        return "Hello World!";
    }

    @GetMapping("/hello/student")
    public String myStudentListener() {
        String jsonText = null;
        Student st1=new Student("Altynai", 18);
        try {
            jsonText = obMapper.writeValueAsString(st1);
        } catch (JsonProcessingException e) {
            System.out.println("Something went wrong"+e.toString());
        }
        return jsonText;
    }
     @PostMapping("/hello/customstudent")
    public String myCustomStudentListener(@RequestParam String name, @RequestParam int age){
        String jsonText=null;
        Student st1=new Student(name, age);
        try{
            jsonText=obMapper.writeValueAsString(st1);
        }catch (JsonProcessingException e) {
            System.out.println("Something went wrong" +e.toString());
        }
         return jsonText;
     }
}
