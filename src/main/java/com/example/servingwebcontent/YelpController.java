package com.example.servingwebcontent;

import com.example.models.BusinessList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class YelpController {
    @GetMapping("yelp")
    public ModelAndView yelp(Map<String, Object> model, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer jiTCndmYGMD0Sm5AGzAijEvAzBKrDltO4_lOBQJ4LrrWvjR2_5VkmR-Cio9c2cbeH9ADRgxX1mn_dz7RDUg9uXF07TJ3gb-dwgYHLU_cOi9gyGjk0i0pKCyH3jlgXnYx");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<BusinessList> response = restTemplate.exchange("https://api.yelp.com/v3/businesses/search?term=delis&latitude=37.786882&longitude=-122.399972", HttpMethod.GET, entity, BusinessList.class);

        model.put("yelp_result", response.getBody().getBusinesses());
        return new ModelAndView("yelp");
    }
}