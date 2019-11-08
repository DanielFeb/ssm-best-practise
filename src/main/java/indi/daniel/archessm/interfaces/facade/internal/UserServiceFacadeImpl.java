package indi.daniel.archessm.interfaces.facade.internal;

import indi.daniel.archessm.domain.auth.model.User;
import indi.daniel.archessm.domain.auth.model.Users;
import indi.daniel.archessm.domain.auth.model.exception.UserNotFoundException;
import indi.daniel.archessm.interfaces.facade.UserServiceFacade;
import indi.daniel.archessm.interfaces.facade.dto.UserDTO;
import indi.daniel.archessm.interfaces.facade.dto.assembler.UserDTOAssembler;
import indi.daniel.archessm.interfaces.shared.exception.ApiException;
import indi.daniel.archessm.interfaces.shared.response.ResponseStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {

    @Autowired
    public UserServiceFacadeImpl() {
    }

    @Override
    public Long addUser(UserDTO userDTO) {
        User user = Users.create(userDTO.getName(), userDTO.getPassword());
        user.setNickname(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setSex(userDTO.getSex());
        user.setAge(userDTO.getAge());
        Users.store(user);
        return user.id().getValue();
    }

    @Override
    public UserDTO getUser(Long idValue) {
        try {
            return UserDTOAssembler.toDTO(Users.get(idValue));
        } catch (UserNotFoundException e) {
            throw new ApiException(ResponseStatusCode.INVALID_ARGUMENT, e);
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        //TODO
    }

    @Override
    public Long getCurrentUserId() {
        //TODO
        return 1L;
    }
}
