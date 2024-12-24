package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tommap.springmapstruct.source_package.Animal;
import org.tommap.springmapstruct.target_package.AnimalDTO;
import org.tommap.springmapstruct.target_package.AnimalFactory;

@Mapper(uses = {AnimalFactory.class})
public interface AnimalMapperInterface {
    @Mapping(target = "animalColor", source = "color")
    AnimalDTO toAnimalDTO(Animal animal);
}
