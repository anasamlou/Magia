import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args){
        //interactuamos con la clase en estático: la creamos
        User u = new User("Jorge", "Nitales");

        //para sacar el nombre de la clase y/o ver los metodos heredados
        System.out.println("class.getName(): "+u.getClass().getName());
        System.out.println("class.getName(): "+u.getClass().getSimpleName());

        //interactuamos con la clase en caliente: CONCEPTO DE REFLEXIÓN
        try{
            Class c = Class.forName(u.getClass().getName());
            User u2 = (User)c.newInstance();
            u2.setName("Elver");
            u2.setSurname("Galarga");
            System.out.println(u2);
            System.out.println("====================");

            for(Field f : c.getDeclaredFields()){
                System.out.println(f.getName());
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
