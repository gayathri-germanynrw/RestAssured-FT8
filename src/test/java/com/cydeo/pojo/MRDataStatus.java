package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MRDataStatus {


    private String limit;
    private String total;

    @JsonProperty("StatusTable")
    private StatusTable statusTable;

    //  Boiler Plate Code
    //  Getter - Setter - Constrs - ToString
}
