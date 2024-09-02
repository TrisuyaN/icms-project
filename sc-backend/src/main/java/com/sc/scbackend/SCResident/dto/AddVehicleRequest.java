package com.sc.scbackend.SCResident.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddVehicleRequest {

    private String licensePlate;

    private byte[] registrationPhoto;

    private Integer residentId;

}
