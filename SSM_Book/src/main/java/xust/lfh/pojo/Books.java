package xust.lfh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by LFH on 2020/2/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private int bookNo;
    private String bookName;
    private String author;
    private String publish;
    private String publishtime;
    private int price;
    private String detail;

}
