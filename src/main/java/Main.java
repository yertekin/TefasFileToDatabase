import dto.FundDetail;
import util.CsvToArray;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CsvToArray csvToArray = new CsvToArray();
        List<FundDetail> fundDetailList = csvToArray.readCSV();
        for (FundDetail fund:fundDetailList) {
            System.out.println(fund.toString());
        }
    }
}
