public class PropertyUp extends Square{
    public String owner;
    public int price;
    public int rent;

    public PropertyUp(String name, int position, int price)
    {
        super(name, position);
        this.price = price;
        rent = price / 10;
    }


}