package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetForecastWeatherMethod extends AbstractApiMethodV2 {
    public GetForecastWeatherMethod(String city){
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("city", city);


    }
}
