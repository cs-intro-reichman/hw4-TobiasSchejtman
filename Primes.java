public class Primes {

    public static void main(String[] args) {
       
        int n = Integer.parseInt(args[0]);
        boolean[] isPrime = sieveOfEratosthenes(n);

        System.out.println("Prime numbers up to " + n + ":");
        
        int primeCount = 0;
        int j = 2; 

        while (j <= n) {
            if (isPrime[j]) {
                System.out.println(j);
                primeCount++;
            }
            j++;
        }

        
        double percentage = (primeCount * 100) / n;
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + (int) percentage + "% are primes)");
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        
        boolean[] isPrime = new boolean[n + 1];

        int i = 2;
        while (i <= n) {
            isPrime[i] = true;
            i++;
        }

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                int multiple = p * p;

                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple += p;
                }
            }
            p++;
        }

        return isPrime;
    }
}

   
