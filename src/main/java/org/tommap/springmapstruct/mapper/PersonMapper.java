package org.tommap.springmapstruct.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.target_package.PersonDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

//@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR) //if there is any unmapped target, it will throw an error
@Mapper
public interface PersonMapper {
    /*
        - defaultValue => if the source value is null, the default value will be used
        - constant => provide a fixed & hardcoded value to the target field, regardless of the source field value
     */
    @Mapping(target = "type", source = "personType")
    @Mapping(target = "occupation", ignore = true)
    @Mapping(target = "employmentStatus", source = "workStatus", defaultValue = "Unemployed")
    @Mapping(target = "numOfChildren", constant = "5")
    @Mapping(target = "age", expression = "java(calculateAge(person.getDob()))")
    @Mapping(target = "introduction", source = "shortInfo", defaultExpression = "java(\"I am a \"+person.getOccupation()+\".\")")
    PersonDTO toPersonDTO(Person person);

    default Integer calculateAge(Date dob) {
        long diffInMillis = Math.abs(new Date().getTime() - dob.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        return (int) (diffInDays / 365);
    }

    List<PersonDTO> toPersonDTOs(List<Person> persons);

    Map<Long, PersonDTO> toPersonDTOMap(Map<Long, Person> personMap);

    Stream<PersonDTO> toPersonDTOStream(Stream<Person> personStream);

    @InheritConfiguration(name = "toPersonDTO") //inherit all mapping configurations from toPersonDTO
    @Mapping(target = "occupation", ignore = false ) //override configurations
    void updatePersonDTO(@MappingTarget PersonDTO personDTO, Person person);

//    @InheritInverseConfiguration(name = "toPersonDTO") //reverse only simple mappings - other configurations need to redefined
//    Person toPerson(PersonDTO personDTO);
}
