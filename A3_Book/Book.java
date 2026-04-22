public class Book
{
    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    public Book()
    {
        title = "Some title";
        price = 0.0;
        author = "Some author";
        ISBN = "0000-0000";
        genre = "uncategorized";
    }

    public Book(String t, double p)
    {
        title = t;
        price = p;
    }

    public Book(String t, double p, String i, String g) throws InvalidPriceException
    {
        if(p < 0)
        {
            throw new InvalidPriceException("Invalid price for book: " + t);
        }

        title = t;
        price = p;
        ISBN = i;
        genre = g;
    }

    public Book(String t, String a, double p, String g)
    {
        title = t;
        author = a;
        price = p;
        genre = g;
    }

    public Book(Book b)
    {
        title = b.title;
        price = b.price;
        ISBN = b.ISBN;
        genre = b.genre;
        author = b.author;
    }
}
