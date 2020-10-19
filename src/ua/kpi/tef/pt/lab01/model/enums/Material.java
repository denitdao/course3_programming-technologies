package ua.kpi.tef.pt.lab01.model.enums;

public enum Material {
    POLYESTER("Polyester"), COTTON("Cotton"), VISCOSE("Viscose"), WOOL("Wool"), SILK("Silk"),
    LEATHER("Leather"), PLASTIC("Plastic"), METAL("Metal");
    private String title;

    Material(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
