package ifmo.se.model;

import java.util.Objects;

/**
 * Класс, представляющий координаты
 */
public class Coordinates {
    private Integer x; //Значение поля должно быть больше -915, Поле не может быть null
    private float y; //Значение поля должно быть больше -75

    public Coordinates(Integer x, float y) {

        if (Objects.isNull(x) || x < -915) {
            throw new IllegalArgumentException("Coordinates must have a positive value");
        }

        if (y < -75) {
            throw new IllegalArgumentException("Coordinates must have a positive value");
        }

        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
