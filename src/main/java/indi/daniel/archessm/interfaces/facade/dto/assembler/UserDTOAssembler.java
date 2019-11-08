package indi.daniel.archessm.interfaces.facade.dto.assembler;

import indi.daniel.archessm.domain.auth.model.User;
import indi.daniel.archessm.interfaces.facade.dto.UserDTO;

public class UserDTOAssembler {
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.id().getValue());
        userDTO.setName(user.nickname());
        userDTO.setSex(user.sex());
        userDTO.setAddress(user.address());
        userDTO.setAge(user.age());
        return userDTO;
    }
}
