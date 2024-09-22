package org.ayeturtles.serversignalreceptor.client;

import org.ayeturtles.serversignalreceptor.model.nests.NestsRes;
import org.ayeturtles.serversignalreceptor.model.records.RecordsReq;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class DbPersistenceClientImpl implements DbPersistenceClient {
    public static final String URL_DB_PERSISTENCE = "http://norsucio.com:8089/dbp";
    private final WebClient webClient = WebClient.create();

    @Override
    public NestsRes getNestBySensorAssignedID(String assignedID) {
        String uri = URL_DB_PERSISTENCE + "/nest/sensor/"+assignedID;
        Mono<NestsRes> response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(NestsRes.class);
        return response.block();
    }

    @Override
    public String sendDataToExternalService(RecordsReq data) {
        Mono<String> response = webClient.post()
                .uri(URL_DB_PERSISTENCE)
                .bodyValue(data)
                .retrieve()
                .bodyToMono(String.class);
        return response.block();
    }
}
