package com.example.demo2.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/*
* @Conroler -> dziedziczy po @Component
* umożliwia dołożenie oddatkową logikę związaną z bazami danych
*
* @RestController ->rest kontroler wszystko co zwrucimy bedzie umieszczone w bodu i trafi do urzytkownika
* */
@RequestMapping("/test")   //dostarcza url i pod takim url'em to bedzie widoczne w przegladarce!! "http://localhost:8080/test"
@RestController
public class PierwszyKontroler {

    @GetMapping("/dodaj/{a}/{b}")      //request wie ze "a" i "b" są parametrami requesta, tak to uruchamiamy=> http://localhost:8080/test/dodaj/3/4/ zczytuje wartosci z URL'a
    public int dodaj(@PathVariable int a, @PathVariable int b){
        return a + b;
    }

    @GetMapping("/odejmij/{a}/{b}/")
    public int odejmij(@PathVariable int a,
                       @PathVariable int b){
        return a - b;
    }

    @GetMapping("/mnozenie/{a}/{b}/")
    public int mnozenie(@PathVariable int a,
                        @PathVariable int b){
        return a * b;
    }


    @GetMapping("/dzienTygodnia/{rok}/{miesiac}/{dzien}")
    public int dzienTygodnia(@PathVariable int dzien,
                             @PathVariable int miesiac,
                             @PathVariable int rok){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, rok);
        calendar.set(Calendar.MONTH, miesiac - 1);
        calendar.set(Calendar.DAY_OF_MONTH, dzien);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }


//    @RequestMapping               //metoda implenetująca @RequestMapping -> tak dzieidziczy po swoim rodzicu (/test)
//    @RequestMapping("/hello")        //teraz url w przglądarce http://localhost:8080/test/hello"
    @GetMapping("/hello")              //robi to co wyżej => @RequestMapping(name ="/hello", method = RequestMethod.GET)
    public String helloworld(){
        return "Hello world";
    }


//    @RequestMapping(method = RequestMethod.POST)  //ta metoda obsluguje POST'a
    @PostMapping                    //robi to co wyżej
    public String helloworld2(){
        return "Hello world2";
    }

}
