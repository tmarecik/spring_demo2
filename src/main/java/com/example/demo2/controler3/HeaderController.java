package com.example.demo2.controler3;


import org.springframework.web.bind.annotation.*;


/*
* teraz przesyłamay parameetry w headrach
* */
@RequestMapping("/header")
@RestController
public class HeaderController {

    @GetMapping("dodaj")
    public int dodaj(@RequestHeader("Header_A") int a,
                     @RequestHeader("Header_B") int b){
        return a + b;
    }

    @GetMapping("odejmij")
    public int odejmij(@RequestHeader("Header_C") int a,
                     @RequestHeader("Header_D") int b){
        return a - b;
    }

    @GetMapping("mnozenie")
    public int mnozenie(@RequestHeader("Header_E") int a,
                     @RequestHeader("Header_F") int b){
        return a * b;
    }


    @GetMapping("/tablice")
    public String tablice(@RequestHeader String[] strs){     //przesyłanie tablic w url
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strs.length; i++){
            sb.append(strs[i]);
            if(i != strs.length -1){
                sb.append(";");
            }
        }

        return sb.toString();
    }


}
