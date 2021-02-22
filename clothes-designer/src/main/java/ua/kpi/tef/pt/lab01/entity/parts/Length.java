package ua.kpi.tef.pt.lab01.entity.parts;

public enum Length {
    SHORT("Short"), LONG("Long");

    private final String title;

    Length(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
