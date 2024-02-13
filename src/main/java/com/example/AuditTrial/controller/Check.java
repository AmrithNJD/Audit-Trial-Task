package com.example.AuditTrial.controller;

import com.example.AuditTrial.entity.prescription;
import com.example.AuditTrial.repo.prescriptionRepo;
import com.example.AuditTrial.service.PresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
//@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class Check {

    @Autowired
   private PresService repository;


    @PostMapping("/save")
    public String saveBook(@RequestBody prescription pre){
        return repository.save(pre);
    }
    @GetMapping("/")
    public String checj(){
        return "done";
    }
    @GetMapping("/webclienttesting")
    public String web()
    {
        WebClient webClient =WebClient.create();
        Flux<String> requestFlux = Flux.just("https://jsonplaceholder.typicode.com/posts");
        Flux<String> getdata =requestFlux.flatMap(url ->
                webClient.get()
                        .uri(url)
                        .retrieve()
                        .bodyToMono(String.class));
        getdata.subscribe(response -> {
            System.out.println("Response: " + response);
        });
        return "Sucess";
    }
    @PostMapping("webclientpost")
    public String webpost()
    {
        Map<String, String> bodyValues = new HashMap<>();
        bodyValues.put("name", "WebClientTest");
        WebClient webClient =WebClient.create();
        Flux<String> requestFlux = Flux.just("http://localhost:8081/post");
        Flux<String> getdata =requestFlux.flatMap(url ->
                webClient.post()
                        .uri(url)

                        .bodyValue(bodyValues)
                        .retrieve()
                        .bodyToMono(String.class));
        getdata.subscribe(response -> {
            System.out.println("Response: " + response);
        });

        return "payload updloaded";
    }
}
