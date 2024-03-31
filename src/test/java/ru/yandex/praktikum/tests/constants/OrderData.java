package ru.yandex.praktikum.tests.constants;

public enum OrderData {

    ORDER_1(
            "Игорь",
            "Иванов",
            "Москва",
            "Бульвар Рокоссовского",
            "89000000003",
            "05",
            "сутки",
            "black"),
    ORDER_2(
            "Алиса",
            "Петрова",
            "Химки",
            "Сокольники",
            "89000008003",
            "14",
            "трое суток",
            "grey");

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String subway;
    private final String phone;
    private final String rentDay;
    private final String rentDuration;
    private final String color;

    OrderData(
            String firstName,
            String lastName,
            String address,
            String subway,
            String phone,
            String rentDay,
            String rentDuration,
            String color
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.rentDay = rentDay;
        this.rentDuration = rentDuration;
        this.color = color;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getSubway() {
        return subway;
    }

    public String getPhone() {
        return phone;
    }

    public String getRentDay() {
        return rentDay;
    }

    public String getRentDuration() {
        return rentDuration;
    }

    public String getColor() {
        return color;
    }
}