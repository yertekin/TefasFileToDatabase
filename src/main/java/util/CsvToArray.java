package util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.opencsv.CSVReader;
import dto.FundDetail;

public class CsvToArray {

    public ArrayList<FundDetail> readCSV() {
        CSVReader reader;
        ArrayList<FundDetail> fundDetails = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyy");
        DecimalFormat d = new DecimalFormat("", new DecimalFormatSymbols(Locale.ITALIAN));
        try
        {
            InputStream is = getClass().getClassLoader().getResourceAsStream("TefasAralik.csv");
            assert is != null;
            reader = new CSVReader(new InputStreamReader(is));
            String [] nextLine;
            //read one line at a time
            while ((nextLine = reader.readNext()) != null){
                FundDetail fundDetail = new FundDetail();
                fundDetail.setPricingDate(simpleDateFormat.parse(nextLine[0]));
                fundDetail.setFundCode(nextLine[1]);
                fundDetail.setPrice(d.parse(nextLine[3]).doubleValue());
                fundDetail.setTotalFundValue(d.parse(nextLine[6]).doubleValue());
                fundDetails.add(fundDetail);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return fundDetails;
    }

}
