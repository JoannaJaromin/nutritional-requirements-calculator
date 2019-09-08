package joanna.jaromin.requirements.calculator.service;

import joanna.jaromin.requirements.calculator.dto.UserDataConverter;
import joanna.jaromin.requirements.calculator.dto.UserDataDto;
import joanna.jaromin.requirements.calculator.exception.RecordNotFoundException;
import joanna.jaromin.requirements.calculator.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserDataRepository userDataRepository;
    private final UserDataConverter userDataConverter;

    @Override
    public UserDataDto findById(int id) {
        return userDataRepository.findById(id)
                .map(userData -> userDataConverter.map(userData, UserDataDto.class))
                .orElseThrow(()->new RecordNotFoundException("Brak danych dla użytkownika o id: " + id));
    }
}
