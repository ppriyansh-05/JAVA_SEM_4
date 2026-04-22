import java.util.ArrayList;

public class ArrayListOfBooks
{
    public static void main(String[] args)
    {
        ArrayList<Book> alb = new ArrayList<>();

        try
        {
            Book b1 = new Book("Icon", 499, "FIC008111", "Fiction");
            Book b2 = new Book("21 Lessons for the 21st Century", 655, "FIC002222", "Fiction");
            Book b3 = new Book("Outlive", 370, "LIF34567", "non-fiction");
            Book b4 = new Book("My Experiments with Truth", 549, "AUT0342198", "Autobiography");

            alb.add(b1);
            alb.add(b2);
            alb.add(b3);
            alb.add(b4);

            Book b5 = new Book("Negative Book", -200, "ERR001", "Fiction");
            alb.add(b5);
        }
        catch(InvalidPriceException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Book details from the ArrayList:");

        double totalPrice = 0;

        for(Book b : alb)
        {
            System.out.println("Title:" + b.title);
            System.out.println("Price:" + b.price);
            System.out.println("ISBN:" + b.ISBN);
            System.out.println("Genre:" + b.genre);
            System.out.println();

            totalPrice += b.price;
        }

        double avg = totalPrice / alb.size();
        System.out.println("Average price of books: " + avg);

        System.out.println("Fiction Books:");

        alb.forEach(b -> {
            if(b.genre.equalsIgnoreCase("Fiction"))
            {
                System.out.println(b.title + " " + b.price);
            }
        });
    }
}
