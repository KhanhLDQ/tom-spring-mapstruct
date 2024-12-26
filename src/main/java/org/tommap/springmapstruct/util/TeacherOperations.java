package org.tommap.springmapstruct.util;

import org.mapstruct.Named;

import java.util.Date;

public class TeacherOperations {
    @Named("toUnemployedInYears")
    public int toUnemployedInYears(Date dob) {
        return 2;
    }
}
