public class Hw3 {

    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        System.out.println("2++: " + a++);
        System.out.println("a: " + a);
        System.out.println("++2: " + ++b);
        System.out.println("b: " + b);

        int i = 3;
        System.out.println("The result of the ternary operation is: " +
                (i < 3 ? i++ + ++i : ++i >>> 1));

        byte c = 0b1010;
        byte d = 0b100;

        System.out.println("The two bytes 0101 and 100 added" +
                " are: " + c+d);

        System.out.println("80 Hours after 23:00, it is: " + (23+80)%24 +
                "\nIt will be " + (23+80)/24 + " days later");

        System.out.println("\nMin vs max:\nByte min value: " +
                Byte.MIN_VALUE + ". Byte max value: " + Byte.MAX_VALUE +
                "\nInteger min value: " + Integer.MIN_VALUE + ". Integer max value: " +
                Integer.MAX_VALUE + "\nLong min value: " +
                Long.MIN_VALUE + ". Long max value: " + Long.MAX_VALUE
                + "\nShort min value: " +
                Short.MIN_VALUE + ". Short max value: " + Short.MAX_VALUE
                + "\nDouble min value: " +
                Double.MIN_VALUE + ". Double max value: " + Double.MAX_VALUE
                + "\nFloat min value: " +
                Float.MIN_VALUE + ". Float max value: " + Float.MAX_VALUE
                + "\nChar min value: " +
                Character.MIN_VALUE + ". Char max value: " + Character.MAX_VALUE);


        Client client1 = new Client("Jan");
        Client client2 = new Client("Piet");
        client2 = client1; // client2 en client1 verwijzen nu naar hetzelfde object
        client2.name = "Joris"; // daarom krijgen beide clients de naam Joris

        System.out.println(client2.name);
    }

    public static class Client{
        String name;

        public Client(String description){
            name = description;
        }
    }

}
