package test_java.tiles.common;

public class CommonTopTCPApplicationPorts extends CommonTopApplicationPorts {

    //**************************************************************************

    @Override
    public String[] getFields(){

        return new String[] {"dport"};
    }

    //**************************************************************************

    @Override
    public String[] getFilters() {

        return new String[] {};
    }

    //**************************************************************************

}