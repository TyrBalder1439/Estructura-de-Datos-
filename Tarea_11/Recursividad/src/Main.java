public class Main {
   // tarea: contrar regresivamente
    public static void main(String[] args) {
        int numeroInicial = 10;
        cuentaRegresiva(numeroInicial);
    }
    public static void cuentaRegresiva(int n) {
        if (n < 0 ){
            System.out.println("cuenta regresiva completada!! =)");
        }else {
            System.out.println("numero");
            System.out.println(n);
            cuentaRegresiva(n - 1);
        }
    }
}