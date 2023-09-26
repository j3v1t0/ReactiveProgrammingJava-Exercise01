

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

        //Print the first number in intNumbersStream that's greater than 5
        //if nothing is found, print -1
        System.out.println("Print the first number that's greater than 5");
        Integer value1 = StreamSource.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value1);

        Integer value2 = StreamSource.intNumbersStream()
                .filter(number -> number > 50)
                .findFirst()
                .orElse(-1);
        System.out.println(value2);

        //Print first names of all users in userStream
        System.out.println("Print first names of all users");
        StreamSource.userStream()
                .map(user -> user.getFirstname())
                .forEach(userName -> System.out.println(userName));

        //Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in users that have IDs from number stream");
        StreamSource.intNumbersStream()
                .flatMap(id -> StreamSource.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstname())
                .forEach(userName -> System.out.println(userName));

        System.out.println("Explaining by part");
        var s = StreamSource.intNumbersStream();
        var s1 = s.flatMap(id -> StreamSource.userStream().filter(user -> user.getId() == id));
        var s2 = s1.map(user -> user.getFirstname());
        s2.forEach(userName -> System.out.println(userName));

        System.out.println("Difference result with map");
        StreamSource.intNumbersStream()
                .flatMap(id -> StreamSource.userStream().filter(user -> user.getId() == id))
                .forEach(userName -> System.out.println(userName));

        System.out.println("2nd Form difference result");
        StreamSource.userStream()
                .filter(u ->
                        StreamSource.intNumbersStream().anyMatch(
                                i -> i == u.getId()
                        ))
                .forEach(System.out::println);

    }
}