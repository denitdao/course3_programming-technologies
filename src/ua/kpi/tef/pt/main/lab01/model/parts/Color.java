package ua.kpi.tef.pt.main.lab01.model.parts;

public enum Color {
    RED("Red"), GREEN("Green"), BLUE("Blue"), YELLOW("Yellow"), BLACK("Black");

    private String title;

    Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

// .values() to get array of enum values
// .ordinal() to get numeric id of enum value