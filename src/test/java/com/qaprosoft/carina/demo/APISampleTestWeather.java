package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.GetCityWeatherMethod;
import com.qaprosoft.carina.demo.api.GetForecastWeatherMethod;
import com.qaprosoft.carina.demo.api.GetInvalidCityWeatherMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APISampleTestWeather extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyGetCityWeather(){
        GetCityWeatherMethod getCityWeatherMethod = new GetCityWeatherMethod("Minsk");
        getCityWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCityWeatherMethod.callAPI();
        getCityWeatherMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyGetForecastWeather(){
        GetForecastWeatherMethod getForecastWeatherMethod = new GetForecastWeatherMethod("Minsk");
        getForecastWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getForecastWeatherMethod.callAPI();
        getForecastWeatherMethod.validateResponseAgainstSchema("api/weather/_get/rsForecast.schema");
    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyGetInvalidCityWeather(){
        GetInvalidCityWeatherMethod getInvalidCityWeatherMethod = new GetInvalidCityWeatherMethod("qwerty");
        getInvalidCityWeatherMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getInvalidCityWeatherMethod.callAPI();
        getInvalidCityWeatherMethod.validateResponseAgainstSchema("api/weather/_get/rsNotFound.schema");

    }


}
