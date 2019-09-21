package indi.daniel.archessm.interfaces.facade.dto.assembler;

import indi.daniel.archessm.domain.model.user.User;
import indi.daniel.archessm.interfaces.facade.dto.UserDTO;

public class UserDTOAssembler {
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.id().getValue());
        userDTO.setName(user.name());
        userDTO.setSex(user.sex());
        userDTO.setAddress(user.address());
        userDTO.setAge(user.age());
        return userDTO;
    }
}
