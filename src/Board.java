public class Board {
    Square[] properties;
    double bank;

    public Board(Square[] properties) {
        this.properties = properties;
        this.bank = 25000.0;
    }

    public void check(Player currentPlayer, Player[] players, Square[] squares, int i, int dice, int playerNo) {

        switch (squares[i].name) {
            case "GO":
                break;

            case "Community Chest":
                break;

            case "Income Tax":
                System.out.println(currentPlayer.name + " has paid $" + ((Tax) squares[i]).price + " for the Income Tax!");
                currentPlayer.money -= ((Tax) squares[i]).price;
                break;

            case "Luxury Tax":
                System.out.println(currentPlayer.name + " has paid $" + ((Tax) squares[i]).price + " for the Luxury Tax!");
                currentPlayer.money -= ((Tax) squares[i]).price;
                break;

            case "Chance":
                break;

            case "Park":
                break;

            case "Go to Jail":
                break;

            case "Jail":
                break;

            default:
                if (squares[i].name.contains("Railroad") || squares[i].name.contains("Line")) {
                    if(((PropertyNon)squares[i]).owner == null) {
                        System.out.println(currentPlayer.name + " has bought " + squares[i].name + " for $" + ((PropertyNon) squares[i]).price + "!");
                        ((PropertyNon) squares[i]).owner = currentPlayer.name;
                    }
                    else
                    {
                        if(currentPlayer.name == ((PropertyNon)squares[i]).owner)
                            System.out.println(currentPlayer.name + " has landed on his own property. Nothing happens!");
                        else {
                            int fin = 4 * dice;
                            for (int j = 0; j < playerNo; j++)
                                if (((PropertyNon) squares[i]).owner.equals(players[j].name)) {
                                    System.out.println(currentPlayer.name + " has paid " + players[j].name + " four times the dice number! That is 4 x " + dice + ", resulting in " + fin);
                                    currentPlayer.money -= fin;
                                    players[j].money += fin;
                                }
                        }

                    }
                }
                else if (squares[i].name.contains("Company") || squares[i].name.contains("Works")) {
                    if(((PropertyNon) squares[i]).owner == null) {
                        System.out.println(currentPlayer.name + " has bought " + squares[i].name + " for $" + ((PropertyNon) squares[i]).price + "!");
                        ((PropertyNon) squares[i]).owner = currentPlayer.name;
                    }
                    else
                    {
                        if(currentPlayer.name == ((PropertyNon)squares[i]).owner)
                            System.out.println(currentPlayer.name + " has landed on his own property. Nothing happens!");
                        else {
                            for (int j = 0; j < playerNo; j++)
                                if (((PropertyNon) squares[i]).owner.equals(players[j].name)) {
                                    System.out.println(currentPlayer.name + " has paid " + players[j].name + " $" + ((PropertyNon) squares[i]).rent + "!");
                                    currentPlayer.money -= ((PropertyNon) squares[i]).rent;
                                    players[j].money += ((PropertyNon) squares[i]).rent;
                                }
                        }

                    }

                }
                else {
                    if(((PropertyUp) squares[i]).owner == null) {
                        System.out.println(currentPlayer.name + " has bought " + squares[i].name + " for $" + ((PropertyUp) squares[i]).price + "!");
                        ((PropertyUp) squares[i]).owner = currentPlayer.name;
                    }
                    else
                    {
                        if(currentPlayer.name == ((PropertyUp)squares[i]).owner)
                            System.out.println(currentPlayer.name + " has landed on his own property. Nothing happens!");
                        else {
                            for (int j = 0; j < playerNo; j++)
                                if (((PropertyUp) squares[i]).owner.equals(players[j].name)) {
                                    System.out.println(currentPlayer.name + " has paid " + players[j].name + " $" + ((PropertyUp) squares[i]).rent + "!");
                                    currentPlayer.money -= ((PropertyUp) squares[i]).rent;
                                    players[j].money += ((PropertyUp) squares[i]).rent;
                                }
                        }

                    }
                }
                break;
        }
    }

}