package com.example.DadataInnCriteria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Comparator;

public class Dadata {
    private static final String DadataHost = "https://suggestions.dadata.ru";
    private static final String SuggestPath = "/suggestions/api/4_1/rs/findById/party";

    private final URI suggestEndpoint;
    private final String apiToken;

    public Dadata(String endpoint, String apiToken) {
        this.suggestEndpoint = URI.create(endpoint);
        this.apiToken = apiToken;
    }

    public Dadata(String apiToken) {
        this(DadataHost + SuggestPath, apiToken);
    }

    public Response GetResponse(String companyFullOrPartName) {
        Response suggests = null;
        {
            HttpClient client = HttpClient.newHttpClient();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            ObjectNode reqBody = mapper.createObjectNode();
            reqBody.put("query", companyFullOrPartName);

            ArrayNode statuses = mapper.createArrayNode();
            statuses.add("ACTIVE");

            reqBody.put("status", statuses);

            try {
                HttpRequest req = HttpRequest.newBuilder().
                        uri(suggestEndpoint).
                        POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(reqBody))).
                        setHeader("Content-Type", "application/json").
                        setHeader("Accept", "application/json").
                        setHeader("Authorization", "Token " + this.apiToken).build();
                HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());

                suggests = mapper.readValue(resp.body(), new TypeReference<>() {
                });


            } catch (IOException | InterruptedException e) {
                System.out.println(e);
            }

        }
        return suggests;
    }

    public void PrintSortedByRegistrationDateAsc(String companyNameInn) {
        Response suggests = GetResponse(companyNameInn);
        suggests.Criteria.sort(Comparator.naturalOrder());
        suggests.PrintSuggests();
    }
}
