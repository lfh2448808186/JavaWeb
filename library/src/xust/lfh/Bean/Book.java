package xust.lfh.Bean;

public class Book {
    private String bookNo;
    private String bookName;
    private String author;
    private String publish;
    private String publishTime;
    private String price;

    public Book() {
    }



    public Book(String bookNo, String bookName, String author, String publish, String publishTime, String price) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.author = author;
        this.publish = publish;
        this.publishTime = publishTime;
        this.price = price;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNo='" + bookNo + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
