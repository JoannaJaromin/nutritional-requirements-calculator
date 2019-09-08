package joanna.jaromin.requirements.calculator.email;

import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import joanna.jaromin.requirements.calculator.dto.UserDataDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

import static joanna.jaromin.requirements.calculator.email.Sex.SEX_FEMALE;

@Component
public class RequirementsIdProvider {

    public int getRequirementsId(MeasurementDto measurementDto, UserDataDto userDataDto) {
        int id;
        LocalDate now = LocalDate.now();
        int ageM = Period.between(userDataDto.getDateOfBirth(), now).getMonths();
        int ageY = Period.between(userDataDto.getDateOfBirth(), now).getYears();
        String sex = userDataDto.getSex();
        boolean pregnant = measurementDto.isPregnant();
        boolean breastfeeding = measurementDto.isBreastfeeding();
        if (SEX_FEMALE.getSex().equals(sex)) {
            id = getRequirementsIdForFemale(ageM, ageY, pregnant, breastfeeding);
        } else {
            id = getRequirementsIdForMale(ageM, ageY);
        }
        return id;
    }

    private int getRequirementsIdForFemale(int ageM, int ageY, Boolean pregnant, Boolean breastfeeding) {
        int id = 0;
        if (!pregnant && !breastfeeding) {
            if (ageY <= 1 && ageM <= 6) {
                id = 14;
            }
            if (ageY <= 1 && ageM > 6) {
                id = 15;
            }
            if (ageY > 1 && ageY <= 3) {
                id = 16;
            }
            if (ageY > 3 && ageY <= 6) {
                id = 17;
            }
            if (ageY > 6 && ageY <= 9) {
                id = 18;
            }
            if (ageY > 9 && ageY <= 12) {
                id = 19;
            }
            if (ageY > 12 && ageY <= 15) {
                id = 20;
            }
            if (ageY > 15 && ageY <= 18) {
                id = 21;
            }
            if (ageY > 18 && ageY <= 30) {
                id = 22;
            }
            if (ageY > 30 && ageY <= 50) {
                id = 23;
            }
            if (ageY > 50 && ageY <= 65) {
                id = 24;
            }
            if (ageY > 65 && ageY <= 75) {
                id = 25;
            }
            if (ageY > 75) {
                id = 26;
            }
        }
        if (pregnant && !breastfeeding && ageY <= 19) {
            id = 27;
        }
        if (pregnant && !breastfeeding && ageY > 19) {
            id = 28;
        }
        if (!pregnant && breastfeeding && ageY <= 19) {
            id = 29;
        }
        if (!pregnant && breastfeeding && ageY > 19) {
            id = 30;
        }
        if (pregnant && breastfeeding && ageY <= 19) {
            id = 31;
        }
        if (pregnant && breastfeeding && ageY > 19) {
            id = 32;
        }
        return id;
    }

    private int getRequirementsIdForMale(int ageM, int ageY) {
        int id = 0;
        if (ageY <= 1 && ageM <= 6) {
            id = 1;
        }
        if (ageY <= 1 && ageM > 6) {
            id = 2;
        }
        if (ageY > 1 && ageY <= 3) {
            id = 3;
        }
        if (ageY > 3 && ageY <= 6) {
            id = 4;
        }
        if (ageY > 6 && ageY <= 9) {
            id = 5;
        }
        if (ageY > 9 && ageY <= 12) {
            id = 6;
        }
        if (ageY > 12 && ageY <= 15) {
            id = 7;
        }
        if (ageY > 15 && ageY <= 18) {
            id = 8;
        }
        if (ageY > 18 && ageY <= 30) {
            id = 9;
        }
        if (ageY > 30 && ageY <= 50) {
            id = 10;
        }
        if (ageY > 50 && ageY <= 65) {
            id = 11;
        }
        if (ageY > 65 && ageY <= 75) {
            id = 12;
        }
        if (ageY > 75) {
            id = 13;
        }
        return id;
    }
}
