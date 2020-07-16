package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	   @Bean
		//configurer  spring cloud gateway statiquement pour les API public
		RouteLocator StaticRoutes(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(r->r.path("/customers/**").uri("http://localhost:8181/").id("r1"))
				.route(r->r.path("/products/**").uri("https://localhost:8282/").id("r2"))
				.route(r->r.path("/biat/**").uri("lb://CUSTOMER-SERVICE").id("r3"))
				/*.route(r->r.path("/publicscountries/**").filters(f->f.addRequestHeader("x-rapidapi-host","restcountries-v1.p.rapidapi.com")
				.addRequestHeader("x-rapidapi-key","65638b4164msh211250a475b1409p17b586jsn8e1f2ffc3370")
				.rewritePath("/publicscountries/(?<segment>.*)","/${segment}")
						//lorsque api est n'est pas disponible il faux définir un retour au lieu de 404 on a utilisé hystrix
						.hystrix(h->h.setName("countries").setFallbackUri("forward:/defaultCountries")))
						.uri( "https://restcountries-v1.p.rapidapi.com").id("route1"))
				.route(r->r.path("/muslim/**").filters(f->f.addRequestHeader("x-rapidapi-host","muslimsalat.p.rapidapi.com")
						.addRequestHeader("x-rapidapi-key","65638b4164msh211250a475b1409p17b586jsn8e1f2ffc3370")
						.rewritePath("/muslim/(?<segment>.*)","/${segment}")
						.hystrix(h->h.setName("countries").setFallbackUri("forward:/defaultdate"))
				)
						.uri( "https://muslimsalat.p.rapidapi.com").id("route2"))*/
				.build();
	}

}
