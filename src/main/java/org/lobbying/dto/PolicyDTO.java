package org.lobbying.dto;

import lombok.*;

@Builder
@Data
public class PolicyDTO {

    private String id;
    private String name;
    private String description;
}
