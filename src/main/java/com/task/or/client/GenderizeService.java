package com.task.or.client;

import com.task.or.web.v1.dtos.genderize.GenderizeDataDTO;

public interface GenderizeService {

    GenderizeDataDTO getGender(String name);
}
