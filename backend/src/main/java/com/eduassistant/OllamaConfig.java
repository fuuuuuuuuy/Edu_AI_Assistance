//package com.eduassistant;
//
//import org.springframework.ai.ollama.OllamaChatClient;
//import org.springframework.ai.ollama.api.OllamaApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration // 标记为配置类
//public class OllamaConfig {
//
//    // 定义 OllamaApi 的 Bean
//    @Bean
//    public OllamaApi ollamaApi() {
//        return new OllamaApi("http://localhost:8003"); // 指定 Ollama 服务地址
//    }
//
//    // 定义 OllamaChatClient 的 Bean，依赖 OllamaApi
//    @Bean
//    public OllamaChatClient ollamaChatClient(OllamaApi ollamaApi) {
//        return new OllamaChatClient(ollamaApi);
//    }
//}
////
////import org.springframework.ai.ollama.OllamaChatClient;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.client.RestTemplate;
////
////@Configuration
////public class OllamaConfig {
////
////    @Bean
////    public RestTemplate restTemplate() {
////        return new RestTemplate();
////    }
////
////    @Bean
////public OllamaChatClient ollamaChatClient() {
////    return OllamaChatClient.builder()
////        .baseUrl(baseUrl)
////        .model(model)
////        .restTemplate(restTemplate())
////        .build();
////}
////}