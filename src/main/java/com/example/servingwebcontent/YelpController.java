package com.example.servingwebcontent;

import com.example.models.BusinessList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class YelpController {

    @GetMapping("yelp")
    public String yelp(@RequestParam(defaultValue = "ramen") String term, Model model, RestTemplate restTemplate) {
        StringBuilder sb = new StringBuilder("https://api.yelp.com/v3/businesses/search?term=");
        sb.append(term);
        sb.append("&latitude=37.786882&longitude=-122.399972");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer jiTCndmYGMD0Sm5AGzAijEvAzBKrDltO4_lOBQJ4LrrWvjR2_5VkmR-Cio9c2cbeH9ADRgxX1mn_dz7RDUg9uXF07TJ3gb-dwgYHLU_cOi9gyGjk0i0pKCyH3jlgXnYx");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<BusinessList> response = restTemplate.exchange(sb.toString(), HttpMethod.GET, entity, BusinessList.class);
        model.addAttribute("yelp_result", response.getBody().getBusinesses());
        return "yelp";
    }
}