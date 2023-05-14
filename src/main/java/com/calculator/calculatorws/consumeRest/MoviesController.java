package com.calculator.calculatorws.consumeRest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MoviesController {

    @GetMapping("/rest/search/{movieTitle}")
    public RestResponse getRestResponse(@PathVariable String movieTitle) {
        return getSearchResults(movieTitle);
    }

    public RestResponse getSearchResults(String movieTitle){
        RestTemplate restTemplate = new RestTemplate();
        RestResponse response = restTemplate.getForObject(
                "http://www.omdbapi.com/?t=" + movieTitle + "&apikey=2235044e",
                RestResponse.class);
        System.err.println("Movie ID " +  response.imdbID);
        System.err.println("Movie title " +  response.title);
        System.err.println("Movie type " +  response.type);
        System.err.println("Movie rating " +  response.imdbRating);
        System.err.println("Movie votes " +  response.imdbVotes);
        return response;
    }
}
