package jdkcompat.lang;

import java.io.File;

public class Runtime4D {

    private static Runtime4D instance;

    private Runtime4D() {

    }

    public Runtime4D getRuntime() {
        if(instance == null) {
            instance = new Runtime4D();
        }
        return instance;
    }
    
    native public Process exec(String[] cmdarray, String[] envp, String dirPath);

    native public void loadLibrary(String libname);

}