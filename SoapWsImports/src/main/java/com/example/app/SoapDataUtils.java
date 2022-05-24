package com.example.app;

import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class SoapDataUtils {

    static final String ENDPOINT = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    private final URL url = URI.create(ENDPOINT).toURL();
    private   final CountryInfoService service = new CountryInfoService(url);
    private final CountryInfoServiceSoapType port = service.getPort(CountryInfoServiceSoapType.class);

    public SoapDataUtils() throws MalformedURLException {
    }

    public   void getCountriesByName()
    {
        for (int x = 0; x < port.listOfCountryNamesByName().tCountryCodeAndName.size(); x++) {

            String name = port.listOfCountryNamesByName().tCountryCodeAndName.get(x).getSName();
            String isoCode = port.listOfCountryNamesByName().tCountryCodeAndName.get(x).getSISOCode();

            System.out.println("Country Name:" + name + "\nCountry Code:" + isoCode + "\n" +
                    "");
        }
    }

    public void getLanguagesByName()
    {
        for (int i = 0; i < port.listOfLanguagesByName().tLanguage.size(); i++)
        {
            String languageName = port.listOfLanguagesByName().tLanguage.get(i).getSName();
            String languageCode = port.listOfLanguagesByName().tLanguage.get(i).getSISOCode();

            System.out.println("Language Name:" + languageName + "\nLanguage Code: " + languageCode + "\n");
        }
    }

}
