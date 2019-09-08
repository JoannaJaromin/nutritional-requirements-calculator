package joanna.jaromin.requirements.calculator.email;

public enum Sex {

    SEX_FEMALE("F"),
    SEX_MALE("M");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

}
