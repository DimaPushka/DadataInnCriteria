package com.example.DadataInnCriteria.service;

import com.example.DadataInnCriteria.Response;

import java.io.File;

public interface WriterService {

    File write(String pathname, Response response);

}
