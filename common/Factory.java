package test_java.common;

public class Factory {

    @SuppressWarnings("unchecked")
    protected static <T> T getInstance(String clazz)
    {
        try {
            return (T)Class.forName(clazz).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {

            System.err.println(
                    Consts.getResetColor() + "\n" +
                    Consts.getBrightRed() + "Error creating " + clazz + " instance:\n" +
                    Consts.getBrightRed() + e + "\n" +
                    Consts.getResetColor()
            );
            System.exit(1);
        }

        return null;
    }

    //**************************************************************************

}