public class Main {
    public static void main(String[] args) {
        double[][] m1 = Matr.getMatrix(500);
        double[][] m2 = Matr.getMatrix(500);

        long mil = System.currentTimeMillis();

        Matr.lineMul(m1, m2);

        long mil2 = System.currentTimeMillis();
        System.out.println(mil2 - mil);

        Matr.multiplyByMatrix(m1, m2);

        System.out.println(System.currentTimeMillis() - mil2);
    }
}
