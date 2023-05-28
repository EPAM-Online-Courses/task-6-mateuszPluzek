package efs.task.functional;

import java.util.*;
import java.util.stream.Collectors;

class PeopleProcessor {

    // TODO: kontynuuj implementację metody tak, aby dla kolekcji (people) obiektów klasy Person zwracała listę
    //       imion ludzi, których wiek jest większy niż podany w argumencie age
    List<String> namesOfPeopleWhoseAgeIsGreaterThan(int age, Collection<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() > age)
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    // TODO: kontynuuj implementację metody tak, aby dla kolekcji (people) obiektów klasy Person zwracała listę
    //       imion ludzi żyjących w danym mieście (cityOfLiving). Lista ma być posortowana po wieku osób.
    List<String> namesOfPeopleSortedByAgeLivingIn(String cityOfLiving, Collection<Person> people) {
        return people.stream()
                .filter(p -> p.getCityOfLiving() == cityOfLiving)
                .sorted(Comparator.comparing(p -> p.getAge()))
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    // TODO: kontynuuj implementację metody tak, aby dla kolekcji (people) obiektów klasy Person zwracała mapę
    //       z informacją o średnim wieku osób w poszczególnych miastach
    Map<String, Double> averageAgeByCityOfLiving(Collection<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getCityOfLiving,
                        Collectors.averagingDouble(Person::getAge)
                        ));
    }
}
