public class Main {
        public static void main(String[] args) {
            ListaLigada<SmartPhone> lista = new ListaLigada<>();
            System.out.println("Contenido de la lista:");
            lista.agregarAlFinal(new SmartPhone("Samsung", "Galaxy S23 plus", 16000));
            lista.agregarAlFinal(new SmartPhone("Apple", "iPhone 15 pro", 24000));
            lista.agregarAlFinal(new SmartPhone("Huawei", "p70 pro", 22000));
            lista.agregarAlFinal(new SmartPhone("Google", "Pixel 7 Pro ", 14000));
            lista.agregarAlFinal(new SmartPhone("Redmi", "Poco", 5697));
            lista.transversal();

            System.out.println("\neliminar posición 2:");
            lista.eliminar(2);
            lista.transversal();

            System.out.println("\nactualizar el segundo elemento:");
            lista.actualizar(new SmartPhone("Apple", "iPhone 15 pro", 24000),  new SmartPhone("Nokia", "Experia x34", 9500));
            lista.transversal();

            System.out.println("\nagregar elementos al inicio y al final:");
            lista.agregarAlInicio(new SmartPhone("Huawei", "P70 Ultra", 26500));
            lista.agregarAlFinal(new SmartPhone("Sony", "Xperia plus", 11700));
            lista.transversal();

            System.out.println("\neliminar el primer elemento:");
            lista.eliminarElPrimero();
            lista.transversal();



        }
}