package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.tommap.springmapstruct.source_package.Animal;
import org.tommap.springmapstruct.target_package.AnimalDTO;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Mapper
public abstract class AnimalMapper {
    @Mapping(target = "animalColor", source = "color")
    public abstract AnimalDTO toAnimalDTO(Animal animal);

    @ObjectFactory
    public AnimalDTO createDTOInstance(Animal animal) {
        System.out.println("from createDTOInstance function");

        long diffInMillis = Math.abs(new Date().getTime() - animal.getDob().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        long diffInYears = diffInDays / 365;

        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setAge((int) diffInYears);

        return animalDTO;
    }
}
