

public class Exercise01 {
    public static void main(String[] args) {
        System.out.println("Print all the numbers");
        //Print all numbers in the intNumbersStream stream
        StreamSource.intNumbersStream().forEach(
                e -> System.out.println(e)
        );

        //Print numbers from intNumbersStream that are less than 5
        System.out.println("Numbers are less than 5");
        StreamSource.intNumbersStream().filter(
                number -> number < 5) // Filter the numbers less than
                .forEach(
                        e -> System.out.println(e)
                );

        //print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers that's greater than 5");
        StreamSource.intNumbersStream()
                .filter(number -> number > 5) // Filter the numbers greater than
                .skip(1) //Number of times to skip
                .limit(2)  //Limit the quantity of result to obtain
                .forEach(
                        e -> System.out.println(e)
                );
    }
}