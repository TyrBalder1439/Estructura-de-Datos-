public class Main {
        public static void main(String[] args) {
            // Crear lista ligada de SmartPhone
            ListaLigada<SmartPhone> lista = new ListaLigada<>();

            // Agregar 5 SmartPhone
            lista.agregarAlFinal(new SmartPhone("Samsung", "Galaxi S23 plus", 16.001));
            lista.agregarAlFinal(new SmartPhone("Apple", "iPhone 15 pro", 24.001));
            lista.agregarAlFinal(new SmartPhone("Huawei", "p70 pro", 22.001));
            lista.agregarAlFinal(new SmartPhone("Google", "Pixel 7 Pro ", 14.001));
            lista.agregarAlFinal(new SmartPhone("Redmi", "Poco", 5.697));
            System.out.println("Contenido de la lista:");
            lista.transversal();
            lista.eliminar(2);
            System.out.println("\nContenido después de eliminar el elemento en la posición 2:");
            lista.transversal();
            lista.actualizar(new SmartPhone("Redmi", "Poco", 5.697), new SmartPhone("Samsung", "Galaxy S22", 899.99));
            System.out.println("\nContenido después de actualizar el segundo elemento:");
            lista.transversal();



        }
}