package ua.kpi.tef.pt.main.lab01.model;

import ua.kpi.tef.pt.main.lab01.model.parts.Name;
import ua.kpi.tef.pt.main.lab01.model.parts.Size;
import ua.kpi.tef.pt.main.lab01.model.parts.Type;

public abstract class Clothes {
    private static long counter = 0;
    protected final long id = ++counter;
    protected String title;
    protected Type type;
    protected Name name;
    protected Size size;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(name.ordinal()).append(type.ordinal()).append(size.ordinal());
        return sb.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Clothes)) return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(":\n(")
                .append(name).append(", ")
                .append(type).append(", ")
                .append(size).append(") hash: ")
                .append(hashCode());
        return sb.toString();
    }
}
