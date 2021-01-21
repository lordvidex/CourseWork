package ru.kpfu.SecondControlWork;

/**
 * Студент ОВАМОЙО О.Э.
 * Группа 11-013
 * Высшая школа информационных технологий и систем
 * Казанский (Приволжский) федеральный университет
 *
 * Контрольная работа №2.
 * //main function
 */
public class SecondControlWork {
    public static void main(String[] args){

        String filename = "MOCK_DATA.csv";
        Users myUsers = new Users(filename);
        //calling the save function
        myUsers.save();
        System.out.println();
        //getUserById
        System.out.println("User of Id:24 ,\n"+myUsers.getUserById(24));

        //this is saved to an array.. we need to call save
        myUsers.findUsersWithParam("gender","Male");
        System.out.println("Data changed.. need to save");
        myUsers.save();

        //interface tests
        User[] users = myUsers.getUsers();
        System.out.println("Maximum salary(money): "+Measurable.getMaximum(users));
        System.out.println("Minimum salary(money): "+Measurable.getMinimum(users));
        System.out.println("Average salary(money): "+Measurable.getAverage(users));
        User firstUser = users[10];
        User secondUser = users[23];
        System.out.println(firstUser);
        System.out.println(secondUser);
        System.out.println("Is "+firstUser.getFirstName()+" "+firstUser.getLastName()+"'s money greater than" +
                secondUser.getFirstName()+" "+secondUser.getLastName()+"'s money? ");
        System.out.println(firstUser.isGreaterThan(secondUser));

        System.out.println("Удачи!");
    }
}
