package com.naito.api.service;

import com.naito.api.Utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Service
public class ClientApiService {

    private HttpClientUtil httpClient;

    @Autowired
    public ClientApiService(HttpClientUtil httpClientUtil) {
        this.httpClient = httpClientUtil;
    }

    public void consumirApi() throws URISyntaxException {
        try {
            httpClient.efetuarRequisicao();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
