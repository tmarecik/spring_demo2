package com.example.demo2.controller4;


import com.example.demo2.model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/body")
@RestController
public class BodyParam {

    @PostMapping(path = "/odwroc", consumes = "text/plain")   //consume okresla jaki typ danych ma byc szukany/wysyłany w body
    public String odwroc(@RequestBody String string){
        char[] znaki = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = znaki.length - 1; i >=0; --i){
            sb.append(znaki[i]);
        }
        return sb.toString();
    }


    @PostMapping(path = "/tablice", consumes = "application/json")   //tutaj w formacie json
    public String tablice(@RequestBody String[] strs){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            sb.append(strs[i]);
            if(i != strs.length -1){
                sb.append(";");
            }
        }
        return sb.toString();
    }

    @PostMapping(path = "/uprosc", consumes = "application/json")
    public String uprosc(@RequestBody User user){
        return user.getImie() + " " + user.getNazwisko() + " lat: " + user.getWiek();
    }




}
