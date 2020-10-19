package ua.kpi.tef.pt.main.lab01.model.enums;

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
