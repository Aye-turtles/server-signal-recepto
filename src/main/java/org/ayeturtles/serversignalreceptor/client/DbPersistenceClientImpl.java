package org.ayeturtles.serversignalreceptor.client;

import org.ayeturtles.serversignalreceptor.model.nests.NestsRes;
import org.ayeturtles.serversignalreceptor.model.records.RecordsReq;
import org.ayeturtles.serversignalreceptor.model.records.RecordsRes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class DbPersistenceClientImpl implements DbPersistenceClient {
    // public static final String URL_DB_PERSISTENCE = "http://norsucio.com:8090/dbp";
    public static final String URL_DB_PERSISTENCE = "http://localhost:8089/dbp";

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
    public List<RecordsRes> getRecordsByNestID(String assignedID) {
        String uri = URL_DB_PERSISTENCE + "/records/nest/"+assignedID;
        Mono<List<RecordsRes>> response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<RecordsRes>>() {});
        return response.block();
    }
    @Override
    public RecordsRes getLastRecordByNestID(String assignedID) {
        String uri = URL_DB_PERSISTENCE + "/records/last/"+assignedID;
        Mono<RecordsRes> response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(RecordsRes.class);
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
