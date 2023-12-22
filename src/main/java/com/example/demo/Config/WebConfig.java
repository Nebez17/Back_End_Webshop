//package com.example.demo.Config;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:4200") // Hier kun je meerdere origins toevoegen als nodig.
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Als voorbeeld
//                .allowCredentials(true);
//    }
//}
