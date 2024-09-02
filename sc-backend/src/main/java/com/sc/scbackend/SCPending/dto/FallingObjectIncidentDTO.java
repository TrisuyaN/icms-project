package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.FallingObjectStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FallingObjectIncidentDTO {

    private String incidentId;

    private FallingObjectStatus status;

    private Integer propertyId;

    private Integer residentId;

    private String injuryDescription;

    private Date incidentDate;

    private String handler;

    private Date handledAt;

    // property

    // 此即为两表联合的 propertyId
//    private Integer id;

    private Integer buildingNumber;

//    private String propertyCode;

    private String roomNumber;

    private String ownerName;

//    private String contactInfo;

//    private BigDecimal area;

//    private Integer numberOfRooms;

    private String unit;

    private Integer floorNumber;

//    private String description;

//    private Date moveInDate;

}
