package foodcalculator.model;

public enum Activity {

    NO("Brak aktywności, praca siedząca", 1.2),
    LOW("mała aktywność fizyczna np. praca biurowa, ćwiczenia raz na kilka dni,", 1.4),
    NORMAL("umiarkowana aktywność fizyczna np. systematyczne i krótkie ćwiczenia kilka razy w tygodniu", 1.6),
    MEDIUM("duża aktywność fizyczna np. codzienne ćwiczenia i ciężka praca fizyczna", 1.8),
    HIGH("zawodowi sportowcy i osoby trenujące wyczynowo", 2.2);


    private String description;
    private double value;

    Activity(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
