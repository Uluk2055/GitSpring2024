package demoqa;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum OldStyleSelectMenuValues {



    GREEN("Green"),
    BLACK("Black");


    String color;
    OldStyleSelectMenuValues(String color) {
        this.color = color;
    }

}
