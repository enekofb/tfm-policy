package org.lobbying.mapper;

import org.lobbying.dto.CreatePolicyDTO;
import org.lobbying.domain.Policy;
import org.lobbying.dto.PolicyDTO;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 11/01/18.
 */
@Component
public class PolicyMapper {

    public Policy from(CreatePolicyDTO createPolicyDto){

        return Policy.builder()
                .name(createPolicyDto.getName())
                .description(createPolicyDto.getDescription())
                .build();

    }

    public PolicyDTO to(Class<PolicyDTO> toClass, Policy createdPolicy) {
        return PolicyDTO.builder()
                .id(createdPolicy.getId())
                .name(createdPolicy.getName())
                .description(createdPolicy.getDescription())
                .build();
    }
}
