package joanna.jaromin.requirements.calculator.service;

import joanna.jaromin.requirements.calculator.entity.Requirements;
import joanna.jaromin.requirements.calculator.repository.RequirementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RequirementsServiceImpl implements RequirementsService {

    private final RequirementsRepository requirementsRepository;

    @Override
    @Transactional(readOnly = true)
    public Requirements findById(int id) {
        return requirementsRepository.findByIdCustom(id);
    }
}
