package ua.kpi.tef.pt.lab01.entity.parts;

public enum Type {
     MAN("Man"), WOMAN("Woman"), CHILDREN("Children");

     private final String title;

     Type(String title) {
          this.title = title;
     }

     @Override
     public String toString() {
          return title;
     }
}
