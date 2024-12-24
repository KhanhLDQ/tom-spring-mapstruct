package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Car;
import org.tommap.springmapstruct.source_package.Driver;
import org.tommap.springmapstruct.target_package.CarDTO;
import org.tommap.springmapstruct.target_package.DriverDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CarDriverMapperTest {
    CarDriverMapper carDriverMapper;
    CarDriverMapperInterface carDriverMapperInterface;
    Driver driver;
    Car car;

    @BeforeEach
    void init() throws ParseException {
        carDriverMapper = Mappers.getMapper(CarDriverMapper.class);
        carDriverMapperInterface = Mappers.getMapper(CarDriverMapperInterface.class);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date expiredDate = dateFormat.parse("02-09-2030");

        driver = new Driver();
        driver.setName("John Doe");
        driver.setLicenseNumber("12345678");
        driver.setLicenseExpiryDate(expiredDate);

        car = new Car();
        car.setRegisterNumber("abcdef");
        car.setModelNumber("bmw-aaaa");
        car.setCompany("BMW");
        car.setDriver(driver);
    }

    @Test
    @DisplayName("Test CarDriverMapper")
    void testCardDriverMapper() {
        // Arrange

        // Act
        CarDTO carDTO = carDriverMapper.toCarDTO(car);

        // Assert
        assertNotNull(carDTO, "CarDTO is null");
        assertEquals("abcdef", carDTO.getRegisterNumber(), "Register number is not equal");
        assertEquals("bmw-aaaa", carDTO.getModelNumber(), "Model number is not equal");
        assertEquals("BMW", carDTO.getCompany(), "Company is not equal");

        DriverDTO driverDTO = carDTO.getDriver();
        assertNotNull(driverDTO, "Driver is null");
        assertEquals("John Doe", driverDTO.getName(), "Driver name is not equal");
        assertEquals("12345678", driverDTO.getLicenseNumber(), "License number is not equal");
        assertEquals(5, driverDTO.getExpiresIn(), "Expires in is not equal");
    }

    @Test
    @DisplayName("Test CarDriverMapperInterface")
    void testCarDriverMapperInterface() {
        //arrange

        //act
        CarDTO carDTO = carDriverMapperInterface.toCarDTO(car);

        //assert
        assertNotNull(carDTO, "CarDTO is null");
        assertEquals("abcdef", carDTO.getRegisterNumber(), "Register number is not equal");
        assertEquals("bmw-aaaa", carDTO.getModelNumber(), "Model number is not equal");
        assertEquals("BMW", carDTO.getCompany(), "Company is not equal");

        DriverDTO driverDTO = carDTO.getDriver();
        assertNotNull(driverDTO, "Driver is null");
        assertEquals("John Doe", driverDTO.getName(), "Driver name is not equal");
        assertEquals("12345678", driverDTO.getLicenseNumber(), "License number is not equal");
        assertEquals(5, driverDTO.getExpiresIn(), "Expires in is not equal");
    }
}
