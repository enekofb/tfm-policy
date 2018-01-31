package org.lobbying.utils.client;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.lobbying.citizen.dto.PolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@NoArgsConstructor
@Setter
public class PolicyClient {

    @Autowired
    private RestTemplate policyRestTemplate;

    @Value("${lobbying.policies.url}")
    private String policyBaseUrl;

    public PolicyClient(RestTemplate policyRestTemplate, String policyBaseUrl) {
        this.policyRestTemplate=policyRestTemplate;
        this.policyBaseUrl = policyBaseUrl;
    }


    protected String getPolicyByIdUrl(){
        return  UriComponentsBuilder.
                fromHttpUrl(policyBaseUrl)
                .pathSegment("{id}")
                .build().toString();

    }
    public PolicyDTO getPolicyById(String policyId) {
        return policyRestTemplate
                .getForObject(getPolicyByIdUrl(), PolicyDTO.class,policyId);
    }

}
