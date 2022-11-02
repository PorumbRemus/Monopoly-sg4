public class PropertyNon extends Square{
    public String owner;
    public int price;
    public int rent;

    public PropertyNon(String name, int position, int price)
    {
        super(name, position);
        this.price = price;
        rent = price / 10;
    }
}