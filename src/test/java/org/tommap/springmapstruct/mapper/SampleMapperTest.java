package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SampleMapperTest {
    @Test
    void impl_obj_test() {
        SampleMapper mapper = new SampleMapperImpl();
        assertNotNull(mapper, "mapper object is null");
    }

    @Test
    void impl_obj_inject_test() {
        SampleMapper mapper = null;
        mapper = Mappers.getMapper(SampleMapper.class);

        assertNotNull(mapper, "mapper object is null");
    }
}
