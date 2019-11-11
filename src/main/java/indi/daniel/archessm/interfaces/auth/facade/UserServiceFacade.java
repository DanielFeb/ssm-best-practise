package indi.daniel.archessm.interfaces.auth.facade;

import indi.daniel.archessm.interfaces.auth.facade.dto.UserDTO;

public interface UserServiceFacade {
    Long addUser(UserDTO userDTO);
    UserDTO getUser(Long idValue);
    void updateUser(UserDTO userDTO);
    Long getCurrentUserId();
}
