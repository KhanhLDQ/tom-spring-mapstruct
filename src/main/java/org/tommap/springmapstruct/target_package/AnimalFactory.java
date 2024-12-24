package org.tommap.springmapstruct.target_package;

import org.mapstruct.ObjectFactory;
import org.tommap.springmapstruct.source_package.Animal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AnimalFactory {
    @ObjectFactory
    public AnimalDTO createDTOInstance(Animal animal) {
        System.out.println("from AnimalFactory.createDTOInstance function");

        long diffInMillis = Math.abs(new Date().getTime() - animal.getDob().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        long diffInYears = diffInDays / 365;

        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setAge((int) diffInYears);

        return animalDTO;
    }
}
