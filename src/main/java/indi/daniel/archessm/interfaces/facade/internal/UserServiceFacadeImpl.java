package indi.daniel.archessm.interfaces.facade.internal;

import indi.daniel.archessm.interfaces.shared.exception.ApiException;
import indi.daniel.archessm.interfaces.shared.response.ResponseStatusCode;
import indi.daniel.archessm.domain.model.user.User;
import indi.daniel.archessm.domain.model.user.UserRepository;
import indi.daniel.archessm.interfaces.facade.UserServiceFacade;
import indi.daniel.archessm.interfaces.facade.dto.UserDTO;
import indi.daniel.archessm.interfaces.facade.dto.assembler.UserDTOAssembler;
import indi.daniel.archessm.domain.model.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceFacadeImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long addUser(UserDTO userDTO) {
        User user = new User(
                userRepository.getNextId(),
                userDTO.getName(),
                userDTO.getSex(),
                userDTO.getAddress(),
                userDTO.getAge());
        userRepository.store(user);
        return user.id().getValue();
    }

    @Override
    public UserDTO getUser(Long idValue) {
        try {
            return UserDTOAssembler.toDTO(userRepository.get(idValue));
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
