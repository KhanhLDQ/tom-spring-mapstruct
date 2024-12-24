package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tommap.springmapstruct.source_package.Company;
import org.tommap.springmapstruct.target_package.CompanyDTO;

@Mapper
public interface CompanyMapper {
    @Mapping(target = "companyZipCode", source = "zipCode")
    public CompanyDTO toCompanyDTO(Company company);
}
