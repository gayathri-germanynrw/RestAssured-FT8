package com.cydeo.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MRDataStatus {


    private String limit;
    private String total;

    private StatusTable statusTable;

    //  Boiler Plate Code
    //  Getter - Setter - Constrs - ToString
}
