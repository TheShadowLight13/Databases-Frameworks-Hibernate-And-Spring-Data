package pr01;

import pr01.interfaces.Drawable;
import pr01.models.Circle;
import pr01.models.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static final int ARGUMENTS_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < ARGUMENTS_COUNT; i++) {
            queue.add(Integer.parseInt(buffReader.readLine()));
        }

        Drawable circle = new Circle(queue.poll());
        Drawable rect = new Rectangle(queue.poll(), queue.poll());

        circle.draw();
        rect.draw();
    }
}
