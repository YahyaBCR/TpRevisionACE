package ma.xproce.tprevision.service.mapper;

import ma.xproce.tprevision.dao.entities.Phone;
import ma.xproce.tprevision.service.dtos.PhoneDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public PhoneDTO fromPhone(Phone phone) {
        return modelMapper.map(phone, PhoneDTO.class);
    }

    public Phone fromPhoneDTO(PhoneDTO phoneDTO) {
        return modelMapper.map(phoneDTO, Phone.class);
    }
}
