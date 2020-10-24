package ua.kpi.tef.pt.main.lab01.model.parts;

public enum Length {
    SHORT("Short"), LONG("Long");

    private String title;

    Length(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
