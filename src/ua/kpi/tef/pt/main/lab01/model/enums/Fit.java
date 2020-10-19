package ua.kpi.tef.pt.main.lab01.model.enums;

public enum Fit {
    SKINNY("Skinny"), SLIM("Slim"), REGULAR("Regular"), CLASSIC("Classic");

    private String title;

    Fit(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
