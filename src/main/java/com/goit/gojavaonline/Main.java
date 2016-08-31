package com.goit.gojavaonline;


import com.goit.gojavaonline.controllers.*;
import com.goit.gojavaonline.model.Employee;
import com.goit.gojavaonline.model.PreparedDish;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tamila on 8/22/16.
 */
public class Main {

    private HEmployeeController hEmployeeController;
    private HDishController hDishController;
    private HOrderController hOrderController;
    private StorageController storageController;
    private PreparedDishController preparedDishController;
    private MenuController menuController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");

        Main main = applicationContext.getBean("main", Main.class);
        main.start();
    }

    private void start() {
        /*hEmployeeController.createEmployee();
        hDishController.createDish();

        hEmployeeController.getAllEmployees().forEach(System.out::println);
        hDishController.getAllDishes().forEach(System.out::println);

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");

        hOrderController.createOrder("John", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes1.add("Potato");
        dishes1.add("Salad");

        hOrderController.createOrder("John", dishes2, 1);
        //hOrderController.getAllOrders().forEach(System.out::println);
        hOrderController.printAllOrders();*/

        /*storageController.getAll().forEach(System.out::println);

        storageController.changeIngredientQuantity(2, 10.0F);
        System.out.println(storageController.getIngredientFromStorage("tomato"));

        StorageIngredient storageIngredient = new StorageIngredient();
        storageIngredient.setId(0);
        storageIngredient.setIngredient(storageController.getIngredientByName("flour"));
        storageIngredient.setQuantity(100);
        storageController.insertIngredientToStorage(storageIngredient);*/

        /*storageController.getAll().forEach(System.out::println);

        storageController.deleteIngredientFromStorage(5);
        System.out.println("_____________");
        storageController.getAll().forEach(System.out::println);*/

        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setDate("2016-01-01");
        Employee e = hEmployeeController.getEmployeeByName("John");
        preparedDish.setCook(e);
        preparedDish.setDish(hDishController.getDishByName("Potato"));
        preparedDish.setOrder(hOrderController.getOrderById(1));
        preparedDishController.insertPreparedDish(preparedDish);

        preparedDishController.printAll();




    }

    public void sethEmployeeController(HEmployeeController hEmployeeController) {
        this.hEmployeeController = hEmployeeController;
    }

    public void sethDishController(HDishController hDishController) {
        this.hDishController = hDishController;
    }

    public void sethOrderController(HOrderController hOrderController) {
        this.hOrderController = hOrderController;
    }

    public void setStorageController(StorageController storageController) {
        this.storageController = storageController;
    }

    public void setPreparedDishController(PreparedDishController preparedDishController) {
        this.preparedDishController = preparedDishController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}
