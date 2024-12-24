package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Company;
import org.tommap.springmapstruct.target_package.CompanyDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CompanyMapperTest {
    CompanyMapper companyMapper;

    @BeforeEach
    void init() {
        companyMapper = Mappers.getMapper(CompanyMapper.class);
    }

    @Test
    void testPublicAccessMapping() {
        //arrange
        Company company = new Company();
        company.name = "name";
        company.address = "address";
        company.country = "country";
        company.zipCode = "zipCode";

        //act
        CompanyDTO companyDTO = companyMapper.toCompanyDTO(company);

        //assert
        assertNotNull(companyMapper, "companyMapper is null");
        assertNotNull(companyDTO, "companyDTO is null");

        assertEquals("name", companyDTO.name, "name should be name");
        assertEquals("address", companyDTO.address, "address should be address");
        assertEquals("country", companyDTO.country, "country should be country");
        assertEquals("zipCode", companyDTO.companyZipCode, "companyZipCode should be zipCode");
    }
}
