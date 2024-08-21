import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Ad", 19),
                new Person("Jack", 18),
                new Person("Jack", 18),
                new Person("Nick", 30),
                new Person("Jack", 21),
                new Person("Ann", 18),
                new Person("Mike", 17),
                new Person("Nil", 25),
                new Person("Bill", 23),
                new Person("Alex", 55)
                );

        Map<Integer, List<Person>> res = people.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));
        System.out.println("Result 1:" +res);

        Map<Boolean, List<Person>> res2 = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 25));
        //downsteam
        System.out.println("Result 2: " + res2 );
        List<Person> people1 = res2.get(true);
        Map<Boolean, Long> res3 = people.stream().
                collect(Collectors.partitioningBy(p -> p.getAge() > 25, Collectors.counting()));

        System.out.println("Result 3: "+ res3);
        Map<Boolean, Set<Person>> res4 = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 25, Collectors.toSet()));
        System.out.println("Result 4: " + res4);

        Map<String, List<Person>> m1 = people.stream().collect(Collectors.groupingBy(p -> p.getName()));


        Integer res5 = people.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> l.size()));
        System.out.println("Result 5: " + res5);

        List<Person> Result_6 = people.stream()
                .toList()
                .stream()
                .filter(p -> p.getAge() > 25)
                .toList();
        System.out.println("Result 6 variant 2:" + Result_6);
    }

}