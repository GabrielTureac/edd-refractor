import java.util.Scanner;

public class CribaComentada {
    /**
     * Este método genera un array de todos los números primos menores o iguales que el número máximo dado.
     * @param max es el número máximo para generar los números primos.
     * @return un array de todos los números primos menores o iguales que el número máximo dado
     */

    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0];
        }

        int dim = max + 1;
        boolean[] esPrimo = new boolean[dim];

        for (int i = 0; i < dim; i++) {
            esPrimo[i] = true;
        }

        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }

        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }

    /**
     * Este método es el punto de entrada para la ejecución del programa y solicita al usuario un número para generar los números primos.
     * Luego, muestra el vector inicial hasta el número ingresado y el vector de números primos hasta el número ingresado.
     */

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();
        int[] vector = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }

        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}
