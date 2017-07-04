package pr01.models;

import pr01.interfaces.Drawable;

public final class Rectangle implements Drawable {

    private int width;

    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < this.getHeight(); i++) {
            System.out.print("*");

            for (int k = 1; k < this.getWidth() - 1; k++) {
                System.out.print(" ");
                if (i == 0 || i == (this.getHeight() - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.print(" ");
            System.out.print("*");
            System.out.print("\n");
        }
    }
}
