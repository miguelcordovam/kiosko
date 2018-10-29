package com.products.meli.controller;

import com.products.meli.domain.Response;
import com.products.meli.util.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.products.meli.util.Constants.BASE_URL;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrentUserUtil currentUserUtil;

    @GetMapping("/active")
    @ResponseBody
    public Object getActiveProducts() {

        String accessToken = currentUserUtil.getAccessToken();
        String userId = currentUserUtil.getUserId();

        StringBuilder url = new StringBuilder(BASE_URL);
        url.append("users/");
        url.append(userId);
        url.append("/items/search?access_token=");
        url.append(accessToken);
        url.append("&status=active");

        Map<String, Object> result = restTemplate.getForObject(url.toString(), Map.class);

        Response response = new Response();
        response.setResult(result.get("results"));
        response.setStatus("OK");

        return response;
    }

    @GetMapping("/paused")
    @ResponseBody
    public Object getPausedProducts() {

        String accessToken = currentUserUtil.getAccessToken();
        String userId = currentUserUtil.getUserId();

        StringBuilder url = new StringBuilder(BASE_URL);
        url.append("users/");
        url.append(userId);
        url.append("/items/search?access_token=");
        url.append(accessToken);
        url.append("&status=paused");

        Map<String, Object> result = restTemplate.getForObject(url.toString(), Map.class);

        Response response = new Response();
        response.setResult(result.get("results"));
        response.setStatus("OK");
        
        return response;
    }
}