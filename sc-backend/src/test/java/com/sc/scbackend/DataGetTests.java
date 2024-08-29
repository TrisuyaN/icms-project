package com.sc.scbackend;

import com.sc.scbackend.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ScBackendApplication.class)
public class DataGetTests {

    @Autowired
    private AnomalyService anomalyService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private ElevatorEntryService elevatorEntryService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ExtremeWeatherService extremeWeatherService;

    @Autowired
    private FallingObjectService fallingObjectService;

    @Autowired
    private FireHydrantService fireHydrantService;

    @Autowired
    private GasInfoService gasInfoService;

    @Autowired
    private GreenEnvironmentInfoService greenEnvironmentInfoService;

    @Autowired
    private LocationInfoService locationInfoService;

    @Autowired
    private ManholeCoverService manholeCoverService;

    @Autowired
    private MemberPropertyService memberPropertyService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MonitoringInfoService monitoringInfoService;

    @Autowired
    private PropertyInfoService propertyInfoService;

    @Autowired
    private RoadEnvironmentInspectionService roadEnvironmentInspectionService;

    @Autowired
    private SuspiciousInfoService suspiciousInfoService;

    @Autowired
    private TrashBinInfoService trashBinInfoService;

    @Autowired
    private TrashBinViolationService trashBinViolationService;

    @Autowired
    private VehicleService vehicleService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void AnomalyServiceTest() {
        System.out.println(anomalyService.getById("KY100001"));
    }

    @Test
    public void ComplaintServiceTest() {
        System.out.println(complaintService.getById("TS100001"));
    }

    @Test
    public void ElevatorEntryServiceTest() {
        System.out.println(elevatorEntryService.getById("DC100001"));
    }

    @Test
    public void EmployeeServiceTest() {
        System.out.println(employeeService.getById("YG10001"));
    }

    @Test
    public void ExtremeWeatherServiceTest() {
        System.out.println(extremeWeatherService.getById("C100001"));
    }

    @Test
    public void FallingObjectServiceTest() {
        System.out.println(fallingObjectService.getById("GK100001"));
    }

    @Test
    public void FireHydrantServiceTest() {
        System.out.println(fireHydrantService.getById("XF100001"));
    }

    @Test
    public void GasInfoServiceTest() {
        System.out.println(gasInfoService.getById("MQ100001"));
    }

    @Test
    public void GreenEnvironmentInfoServiceTest() {
        System.out.println(greenEnvironmentInfoService.getById("G100001"));
    }

    @Test
    public void LocationInfoServiceTest() {
        System.out.println(locationInfoService.getById("40001"));
    }

    @Test
    public void ManholeCoverServiceTest() {
        System.out.println(manholeCoverService.getById("JG100001"));
    }

    @Test
    public void MemberPropertyServiceTest() {
        System.out.println(memberPropertyService.getById("10000001"));
    }

    @Test
    public void MemberServiceTest() {
        System.out.println(memberService.getById("10000001"));
    }

    @Test
    public void MonitoringInfoServiceTest() {
        System.out.println(monitoringInfoService.getById("1"));
    }

    @Test
    public void PropertyInfoServiceTest() {
        System.out.println(propertyInfoService.getById("1"));
    }

    @Test
    public void RoadEnvironmentInspectionServiceTest() {
        System.out.println(roadEnvironmentInspectionService.getById("R100001"));
    }

    @Test
    public void SuspiciousInfoServiceTest() {
        System.out.println(suspiciousInfoService.getById("KY100001"));
    }

    @Test
    public void TrashBinInfoServiceTest() {
        System.out.println(trashBinInfoService.getById("T100001"));
    }

    @Test
    public void TrashBinViolationServiceTest() {
        System.out.println(trashBinViolationService.getById("violationId"));
    }

    @Test
    public void VehicleServiceTest() {
        System.out.println(vehicleService.getById("30001"));
    }

}
