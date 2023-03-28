package com.example.DadataInnCriteria.service;

import com.example.DadataInnCriteria.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {

    private static final Logger logger = LoggerFactory.getLogger(WriterServiceImpl.class);
    private final ObjectMapper jsonObjectMapper;

    public WriterServiceImpl(ObjectMapper jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    @Override
    public File write(String pathname, Response response) {
        File resultFile = new File(pathname);
        try {
            jsonObjectMapper.writeValue(resultFile, response);
        } catch (IOException e) {
            logger.error("Ошибка записи в файл", e);
        }
        return resultFile;
    }
}
