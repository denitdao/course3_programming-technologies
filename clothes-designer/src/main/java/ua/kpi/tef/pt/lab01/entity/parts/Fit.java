package ua.kpi.tef.pt.lab01.entity.parts;

public enum Fit {
    SKINNY("Skinny"), SLIM("Slim"), REGULAR("Regular"), CLASSIC("Classic");

    private final String title;

    Fit(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
