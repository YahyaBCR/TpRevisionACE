package ma.xproce.tprevision.service;

import ma.xproce.tprevision.service.dtos.PhoneDTO;

import java.util.List;

public interface PhoneManager {
    PhoneDTO savePhone(PhoneDTO phoneDTO);
    PhoneDTO deletePhone(Long id);
    List<PhoneDTO> getPhoneByModel(String model);
    List<PhoneDTO> getPhoneByModelAndPrice(String model, Float price);
}



