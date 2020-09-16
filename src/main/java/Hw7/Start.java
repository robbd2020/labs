package Hw7;

public class Start {
    public static void main(String[] args) {
        Hw7.Person jan = new Hw7.Person("Jan", 130);
        try {
            jan.haveBirthday();
        } catch (PersonDiedException e) {
            System.out.println(e.getMessage());
        }
    }
}
