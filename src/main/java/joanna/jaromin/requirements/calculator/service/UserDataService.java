package joanna.jaromin.requirements.calculator.service;

import joanna.jaromin.requirements.calculator.dto.UserDataDto;

public interface UserDataService {


    UserDataDto findById(int id);
}
