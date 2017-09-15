package com.yuriy.printer.model;

import lombok.*;

import java.awt.*;

/**
 * Created by Kucya on 03.09.2017.
 */
@EqualsAndHashCode
@Data
@RequiredArgsConstructor
@Getter
public class Text {

    private final String text;
    private final Color color;
    private final int leftAlignment;
    private final int rightAlignment;

    public static class TextBuilder {
        public static Text build() {
            return new Text(null, null, 0, 0);
        }
    }

    public Text withText(final String text) {
        return new Text(text, this.color, this.leftAlignment, this.rightAlignment);
    }

    public Text withColor(final Color color) {
        return new Text(this.text, color, this.leftAlignment, this.rightAlignment);
    }

    public Text withLeftAlignment(final int leftAlignment) {
        return new Text(this.text, this.color, leftAlignment, this.rightAlignment);
    }

    public Text withRightAlignment(final int rightAlignment) {
        return new Text(this.text, this.color, this.leftAlignment, rightAlignment);
    }
}
