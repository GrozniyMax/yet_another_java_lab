package ifmo.se.model;

import java.util.Date;
import java.util.Objects;

/**
 * Класс, представляющий квартиру
 */
public class Flat implements Comparable<Flat> {

    /**
     * Вложенный класс, реализующий паттерн Builder
     */
    public static class Builder {

        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private Float area; //Максимальное значение поля: 525, Значение поля должно быть больше 0
        private Long numberOfRooms; //Значение поля должно быть больше 0
        private Furnish furnish; //Поле не может быть null
        private View view; //Поле может быть null
        private Transport transport; //Поле не может быть null
        private House house;//Поле может быть null


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder coordinates(Coordinates coordinates) {
            Objects.requireNonNull(coordinates, "coordinates must not be null");
            this.coordinates = coordinates;
            return this;
        }

        public Builder area(Float area) {
            if (area < 0 || area > 525) {
                throw new IllegalArgumentException("Area out of range");
            }
            this.area = area;
            return this;
        }

        public Builder numberOfRooms(Long numberOfRooms) {
            if (numberOfRooms  < 0) {
                throw new IllegalArgumentException("Number of rooms must not be negative");
            }
            this.numberOfRooms = numberOfRooms;
            return this;
        }

        public Builder furnish(Furnish furnish) {
            Objects.requireNonNull(furnish, "furnish must not be null");
            this.furnish = furnish;
            return this;
        }

        public Builder view(View view) {
            Objects.requireNonNull(view, "view must not be null");
            this.view = view;
            return this;
        }

        public Builder transport(Transport transport) {
            Objects.requireNonNull(transport, "transport must not be null");
            this.transport = transport;
            return this;
        }

        public Builder house(House house) {
            this.house = house;
            return this;
        }

        public Flat build() {
            return new Flat(name, coordinates, area, numberOfRooms, furnish, view, transport, house);
        }
    }


    public static Builder builder() {
        return new Builder();
    }



    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float area; //Максимальное значение поля: 525, Значение поля должно быть больше 0
    private Long numberOfRooms; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле не может быть null
    private View view; //Поле может быть null
    private Transport transport; //Поле не может быть null
    private House house;//Поле может быть null


    private Flat(String name, Coordinates coordinates, Float area, Long numberOfRooms, Furnish furnish, View view,
                 Transport transport, House house) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.furnish = furnish;
        this.view = view;
        this.transport = transport;
        this.house = house;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Float getArea() {
        return area;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public View getView() {
        return view;
    }

    public Transport getTransport() {
        return transport;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public int compareTo(Flat o) {
        return Float.compare(this.area, o.area);
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", furnish=" + furnish +
                ", view=" + view +
                ", transport=" + transport +
                ", house=" + house +
                '}';
    }
}





