package Service;

import model.User;

import java.util.ArrayList;
import java.util.List;


public class JPAUsersImpl implements JPAUsers {
    private static List<User> users = new ArrayList<User>();
    public static User user;

    @Override
    public void create(String body) {

        String[] data = body.split(",");

        user = new User(0, data[0], data[1], data[2]);
        String response = "Se ha creado el usuario con exito y sus datos son:\n" + "Id:" + user.getId() + ", " + " Nombres: " + user.getNames() + ", " +
                "Email: " + user.getEmail() + ", " + "Teléfono: " + user.getPhone();
        //int id = users.size()+ 1;
        //user.setId(id);//sino se le asigna el id, el id siempre será el mismo
        //user.setId(User.getId()+1);//incrementamos el id automaticamente cada vez que se cree un nuevo usuario
        users.add(user);//adicionamos el objeto
        System.out.println(response);
    }


    @Override
    public List<User> readAll() {
        printUsers(users);
        return users;
    }

    //prod = new Producto(listaProductos.get(i).getCodigo(), nombre, descrip, pCompra, pVenta, cantidad);
    //listaProductos.set(i, prod); // se agrega en la posicion del codigo encontrado, el nuevo objeto con sus parametros
    @Override
    public void updateById(String body, int id) throws IndexOutOfBoundsException {
        //int indice = users.indexOf(id);
        //if (indice != -1) {    //si el indice es diferente de -1, es decir, si existe el usuario

        for (User usuario : users) {
            if (usuario.getId() == id) {
                String[] data = body.split(",");
                user.setNames(data[0]);
                user.setEmail(data[1]);
                user.setPhone(data[2]);
                users.set(id, user);
                //user.setId(id);//reconfirmamos  el id
                break;
            }
        }//end for
        System.out.println("Se ha actualizado el usuario con éxito y sus datos son:\n" + "Id:" + user.getId() + ", " + " Nombres: " + user.getNames() + ", " +
                "Email: " + user.getEmail() + ", " + "Teléfono: " + user.getPhone());
        //} else {
        //   System.out.println("No se ha encontrado el usuario con el id: " + id);
        // }
    }


    @Override
    public void deleteById(int id) throws IndexOutOfBoundsException {
        boolean encontrado = false;
        //for (User usuario : users) {
        users.removeIf(p -> p.getId() == id);
        //if (usuario.getId() == id) {
        //encontrado = true;
        //users.remove(usuario);

        // break;
        //}
        //}//end for
        /*if(encontrado ==false)

    {
        System.out.println("No se ha encontrado el usuario con el id: " + id);
    };*/
        System.out.println("Se ha eliminado el usuario con Id:" + id);

        printUsers(users);

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findById(int id) {
        for (User usuario : users) {
            if (usuario.getId() == id) {
                System.out.println("Se ha encontrado el usuario con Id:" + id);
                System.out.println(usuario.toString());
            }//end if
        }//end for
    }

    static void printUsers(List<User> users) {
        System.out.println("Lista de usuarios:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("\n{\n\t\"id\":" + users.get(i).getId() + "," + "\n\t\"nombres\":" + users.get(i).getNames() + "\"," +
                    "\n\t\"email\":" + "\"" + users.get(i).getEmail() + "\",\n\t\"phone\":" + "\"" + users.get(i).getPhone() + "\"\n\t\t\t\t\t\t},");
        }
    }
}
