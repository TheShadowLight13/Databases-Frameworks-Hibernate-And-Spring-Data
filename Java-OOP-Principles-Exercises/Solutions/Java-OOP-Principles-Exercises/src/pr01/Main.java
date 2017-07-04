package pr01;

import pr01.interfaces.Birthable;
import pr01.interfaces.Identifiable;
import pr01.models.Citizen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Class> citizenInterfaces = Arrays.asList(Citizen.class.getInterfaces());

        if (citizenInterfaces.contains(Birthable.class)
                && citizenInterfaces.contains(Identifiable.class)) {

            Method[] methods = Birthable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            methods = Identifiable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());

            BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

            String name = buffReader.readLine();
            int age = Integer.parseInt(buffReader.readLine());
            String id = buffReader.readLine();
            String birthdate = buffReader.readLine();
            Identifiable identifiable = new Citizen(name, age, id, birthdate);
            Birthable birthable = new Citizen(name, age, id, birthdate);
        }
    }
}
