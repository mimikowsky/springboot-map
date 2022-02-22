package com.example.springbootmap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CapitalsParser {
    
    private static final String url = "https://raw.githubusercontent.com/reganjohn/BHI/master/topology/country-capitals.csv";
    
    
    public List<Point> getCapitalData() throws IOException {
        List<Point> points = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String values = restTemplate.getForObject(url, String.class);

        StringReader stringReader = new StringReader(values);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
        
        for(CSVRecord data : parser){
            String country = data.get("country");
            String capital = data.get("capital");
            double lon = Double.parseDouble(data.get("longitude"));
            double lat = Double.parseDouble(data.get("latitude"));
            points.add(new Point(lon, lat,  capital + ", \n" + country));
        }
        return points;
    }
}
