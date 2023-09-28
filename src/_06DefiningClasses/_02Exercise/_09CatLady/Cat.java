package _06DefiningClasses._02Exercise._09CatLady;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    protected String className() {
        return getClass().toString().substring(getClass().toString().lastIndexOf(".") + 1);
    }
}
