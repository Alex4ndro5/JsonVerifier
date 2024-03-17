package org.alex4ndo5.DTOs;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class IAMRolePolicy {
    private String PolicyName;
    private PolicyDocument PolicyDocument;
}
