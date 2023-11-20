package models.components;

import java.lang.reflect.Constructor;

public class ComponentExploring {

    // Boundary generic type
    public <T extends LoginPage> void login(Class<T> loginPageClass, String usernameStr ){
        // Wildcard generic type
        Class<?>[] parameters = new Class[]{};

        try {
            // Java reflection
            Constructor<T> constructor = loginPageClass.getConstructor(parameters);
            T loginPageObj = constructor.newInstance();

            loginPageObj.inputUserName(usernameStr);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
