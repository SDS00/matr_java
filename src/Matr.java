import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class Matr {
    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;
        if(m1ColLength != m2RowLength) return null;
        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {
            int ii = i;

            (new Thread(() -> {
                for(int j = 0; j < mRColLength; j++) {
                    int jj = j;

                    CompletableFuture.runAsync(() -> {
                        for(int k = 0; k < m1ColLength; k++) {
                            mResult[ii][jj] += m1[ii][k] * m2[k][jj];
                        }
                    });
                }
            })).start();
        }
        return mResult;
    }

    public static double[][] lineMul(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;
        if(m1ColLength != m2RowLength) return null;
        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {
            for(int j = 0; j < mRColLength; j++) {
                for(int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    public static double[][] getMatrix(int size) {
        double[][] matr = new double[size][size];

        int a = 0;
        int b = 9;

        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr.length; j++) {
                matr[i][j] = a + (int) (Math.random() * b);
            }
        }

        return matr;
    }

    public static String toString(double[][] m) {
        String result = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result += String.format("%11.2f", m[i][j]);
            }
            result += "\n";
        }
        return result;
    }
}
