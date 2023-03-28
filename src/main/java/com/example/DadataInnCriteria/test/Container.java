package com.example.DadataInnCriteria.test;

import com.example.DadataInnCriteria.Dadata;
import com.example.DadataInnCriteria.service.CompanyService;
import com.example.DadataInnCriteria.service.WriterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.squareup.okhttp.OkHttpClient;

import java.net.http.HttpClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Container {

    private static Container instance;

    private final ObjectMapper jsonObjectMapper;
    private final CompanyService companyService;
    private final WriterService writerService;



    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public WriterService getWriterService() {
        return writerService;
    }

    private void configureJsonMapper() {
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        this.jsonObjectMapper.registerModule(timeModule);
    }
}
