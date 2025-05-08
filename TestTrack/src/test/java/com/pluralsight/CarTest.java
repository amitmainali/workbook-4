package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void accelerate_should_increaseCarSpeed() {
        // arrange
        Car car = new Car("Honda","Accord");
        int speedChange = 15;
        int expectedSpeed = 15;

        // act
        car.accelerate(speedChange);

        // assert
        assertEquals(expectedSpeed, car.getSpeed());

    }
}