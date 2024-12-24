package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.tommap.springmapstruct.source_package.Car;
import org.tommap.springmapstruct.source_package.Driver;
import org.tommap.springmapstruct.target_package.CarDTO;
import org.tommap.springmapstruct.target_package.DriverDTO;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Mapper
public abstract class CarDriverMapper {
    public abstract CarDTO toCarDTO(Car car);
    public DriverDTO toDriverDTO(Driver driver) {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setLicenseNumber(driver.getLicenseNumber());
        driverDTO.setName(driver.getName());

        long diffInMillis = Math.abs(new Date().getTime() - driver.getLicenseExpiryDate().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        long diffInYears = diffInDays / 365;
        driverDTO.setExpiresIn((int) diffInYears);

        return driverDTO;
    }
}
