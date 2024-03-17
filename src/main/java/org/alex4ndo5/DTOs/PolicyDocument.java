package org.alex4ndo5.DTOs;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class PolicyDocument {
    private LocalDate Version;
    @Setter
    private List<Statement> Statement;

    public void setVersion(String version){
        this.Version = LocalDate.parse(version);
    }
}
