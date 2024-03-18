package org.alex4ndro5.DTOs;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Statement {
    private String Sid;
    private String Effect;
    private List<String> Action;
    private String Resource;
}
