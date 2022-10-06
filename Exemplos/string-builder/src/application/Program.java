package application;

import entities.Comment;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("TheDog apenas.");
        Comment c2 = new Comment("Brabo demais!");
        Post p1 = new Post(sdf.parse("06/10/2022 20:35:00"), "Viajando para Maruin", "Vou viajar para essa terra de brabos", 12);
        p1.addComment(c1);
        p1.addComment(c2);

        Comment c3 = new Comment("TheDog apenas.");
        Comment c4 = new Comment("Brabo demais!");

        Post p2 = new Post(sdf.parse("06/10/2022 20:35:00"), "Viajando para Capelinha", "Apenas", 12);
        p1.addComment(c3);
        p1.addComment(c4);


        System.out.println(p1);
        System.out.println(p2);
        sc.close();
    }
}
