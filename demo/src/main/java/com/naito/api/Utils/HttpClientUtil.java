package com.naito.api.Utils;

import com.fasterxml.jackson.core.JsonGenerator;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class HttpClientUtil {

    private final String URL = "http://127.0.0.1:8080/";

    protected Client client = ClientBuilder.newClient().register(ResteasyProviderFactory.getInstance());

    public HttpClientUtil() throws IOException {
        super();
    }

    public void efetuarRequisicao() throws MalformedURLException, URISyntaxException {

        final Response response = this.client.target(new URI(URL))
                .path("api/empresa")
                .request(MediaType.APPLICATION_JSON)
                .get();

        this.responseToJson(response.readEntity(InputStream.class));

    }

    private List<String> responseToJson(InputStream response) {

        List<String> strings = new ArrayList<>();
        try {
            strings = IOUtils.readLines(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(strings);
        return strings;
    }


    private void stringToJson(List<String> arrayList){

        JsonGenerator generator;

        File file = new File("./teste");
        file.setWritable(true);

        try {
            final JsonParser jsonParser = JsonParserFactory.getJsonParser();

            for (String listItem : arrayList) {
                System.out.println(jsonParser.parseList(listItem));
            }

        }catch (Exception e){
            System.out.println("e = " + e);
        }
    }
}
