package com.example.servingwebcontent;

import com.example.models.BusinessList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class YelpController {
    @GetMapping("yelp")
    public String yelp(@RequestParam(defaultValue = "ramen") String term, @RequestParam(defaultValue = "Santa Clara") String location,Model model, RestTemplate restTemplate) {
        // translate location into latitude and longitude



        StringBuilder sb = new StringBuilder("https://api.yelp.com/v3/businesses/search?term=");
        sb.append(term);
        sb.append("&location=");
        sb.append(location);
//        String longitude = "-122.399972";
//        String latitude = "37.786882";
//        sb.append("&longitude=");
//        sb.append(longitude);
//        sb.append("&latitude=");
//        sb.append(latitude);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer jiTCndmYGMD0Sm5AGzAijEvAzBKrDltO4_lOBQJ4LrrWvjR2_5VkmR-Cio9c2cbeH9ADRgxX1mn_dz7RDUg9uXF07TJ3gb-dwgYHLU_cOi9gyGjk0i0pKCyH3jlgXnYx");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<BusinessList> response = restTemplate.exchange(sb.toString(), HttpMethod.GET, entity, BusinessList.class);
        model.addAttribute("yelp_result", response.getBody().getBusinesses());
        return "yelp";
    }
}