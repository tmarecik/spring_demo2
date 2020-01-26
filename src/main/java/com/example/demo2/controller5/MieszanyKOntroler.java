package com.example.demo2.controller5;

import com.example.demo2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RequestMapping("/mieszany")
@RestController
public class MieszanyKOntroler {

    private User user;

    @GetMapping
    public User dostan(){
        return user;
    }

    @PostMapping  //stworzy cos w systemie
    public User stworz(@RequestParam String imie,
                       @RequestParam String nazwisko,
                       @RequestParam int wiek){
        user = new User(imie, nazwisko, wiek);
        return user;
    }


    @PatchMapping("dodaj/{uprawinienia}")    //Path do cześciowej modyfikacji
    public User dodaj(@PathVariable String uprawinienia){
        if(user == null){
            throw new NotFoundException();
        }
        user.addUprawnienie(uprawinienia);
        return user;
    }

    @PatchMapping("usun/{uprawinienia}")
    public User usun(@PathVariable String uprawinienia){
        if(user == null){
            throw new NotFoundException();
        }
        user.removeUprawnienie(uprawinienia);
        return user;
    }

    @DeleteMapping
    public void usun(){
        user = null;
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND)  //dodawane nad wyjatkami
    public static class NotFoundException extends RuntimeException{
    }

}
