package ma.xproce.tprevision.web;

import ma.xproce.tprevision.service.PhoneManager;
import ma.xproce.tprevision.service.dtos.PhoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PhoneGraphQLController {
    @Autowired
    private PhoneManager phoneManager;

    @QueryMapping
    public List<PhoneDTO> getPhoneByModel(@Argument String model) {
        return phoneManager.getPhoneByModel(model);
    }

    @QueryMapping
    public List<PhoneDTO> getPhoneByModelAndPrice(@Argument String model, @Argument Float price) {
        return phoneManager.getPhoneByModelAndPrice(model, price);
    }

    @MutationMapping
    public PhoneDTO savePhone(@Argument PhoneDTO phone) {
        return phoneManager.savePhone(phone);
    }

    @MutationMapping
    public PhoneDTO deletePhone(@Argument Long id) {
        return phoneManager.deletePhone(id);
    }
}
