package viva.poc.api.server.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import viva.poc.api.server.fakeData.UserData;

import com.google.gson.Gson;

@RestController
public class StatusController {

    @GetMapping("/health")
    @ResponseBody
    public String unprotectedApi() { 

        Gson gson = new Gson();
        
        UserData user1 = new UserData("Nadeem", 52);
        String user1String = gson.toJson(user1);

        System.out.println(user1);
        System.out.println(user1String);

        
        return user1String;    
    }

    @GetMapping("/status")
    @ResponseBody
    public String checkApi() { 

        Gson gson = new Gson();
        
        UserData user1 = new UserData("Viva", 2);
        String user1String = gson.toJson(user1);

        System.out.println(user1);
        System.out.println(user1String);

        
        return user1String;    
    }

    
    @GetMapping("/api")
    public String protectedApi() {
        Gson gson = new Gson();
        
        UserData user1 = new UserData("Khalid", 54);
        String user1String = gson.toJson(user1);

        System.out.println(user1);
        System.out.println(user1String);

        
        return user1String;
    }

    
}
