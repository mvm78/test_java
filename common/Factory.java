package test_java.common;

public class Factory {

    @SuppressWarnings("unchecked")
    protected static <T> T getInstance(String clazz)
    {
        try {
            return (T)Class.forName(clazz).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {

            System.err.println(
                    Consts.RESET_COLOR + "\n" +
                    Consts.BRIGHT_RED + "Error creating " + clazz + " instance:\n" +
                    Consts.BRIGHT_RED + e + "\n" +
                    Consts.RESET_COLOR
            );
            System.exit(1);
        }

        return null;
    }

    //**************************************************************************

}