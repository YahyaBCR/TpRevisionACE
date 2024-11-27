package ma.xproce.tprevision.service;

import jakarta.transaction.Transactional;
import ma.xproce.tprevision.dao.entities.Phone;
import ma.xproce.tprevision.dao.repositories.PhoneRepository;
import ma.xproce.tprevision.service.dtos.PhoneDTO;
import ma.xproce.tprevision.service.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PhoneManagerAction implements PhoneManager {
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private PhoneMapper phoneMapper;

    @Override
    public PhoneDTO savePhone(PhoneDTO phoneDTO) {
        // Vérifier si l'IMEI existe déjà
        if(phoneRepository.findByIMEI(phoneDTO.getIMEI()).isPresent()) {
            throw new RuntimeException("IMEI already exists");
        }
        Phone phone = phoneMapper.fromPhoneDTO(phoneDTO);
        Phone savedPhone = phoneRepository.save(phone);
        return phoneMapper.fromPhone(savedPhone);
    }

    @Override
    public PhoneDTO deletePhone(Long id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        phoneRepository.delete(phone);
        return phoneMapper.fromPhone(phone);
    }

    @Override
    public List<PhoneDTO> getPhoneByModel(String model) {
        return phoneRepository.findByModel(model)
                .stream()
                .map(phone -> phoneMapper.fromPhone(phone))
                .collect(Collectors.toList());
    }

    @Override
    public List<PhoneDTO> getPhoneByModelAndPrice(String model, Float price) {
        return phoneRepository.findByModelAndPrice(model, price)
                .stream()
                .map(phone -> phoneMapper.fromPhone(phone))
                .collect(Collectors.toList());
    }
}
