public class Tax extends Square{
    public String owner;
    public int price;

    public Tax(String name, int position, int price)
    {
        super(name, position);
        this.price = price;
    }

}