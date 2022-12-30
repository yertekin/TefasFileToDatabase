package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class FundDetail {

    private Date pricingDate;
    private String fundCode;
    private Double price;
    private Double totalFundValue;

}
