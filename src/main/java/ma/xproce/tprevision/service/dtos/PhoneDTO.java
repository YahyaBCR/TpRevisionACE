package ma.xproce.tprevision.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {
    private String model;
    private String color;
    private String IMEI;
    private Float price;
}