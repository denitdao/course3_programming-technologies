package ua.kpi.tef.pt.lab01.entity.parts;

public enum Size {
    XS("XS"), S("S"), M("M"), L("L"), XL("XL");
    private final String title;

    Size(String title) { // не нужно вызывать конструктор извне
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
