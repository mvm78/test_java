package test_java.reports;

import java.util.*;

public class SNMP extends Report {

    //**************************************************************************

    public SNMP() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "SNMP";
        this.tilesFolder = "SNMP";

        this.tileList = new HashMap<String, String []>() {{
            put("charts", new String [] {
                "SNMPVariablesChart",
            });
            put("tables", new String [] {
                "SNMPTopDeviceInterface",
                "SNMPVariables",
            });
        }};

        this.tallyCheck = new HashMap<String, String []>() {{
            put("SNMPTopDeviceInterface", new String [] {
                "SNMPVariables",
                "SNMPVariablesChart",
            });
        }};
    };

    //**************************************************************************

    @Override
    protected String getTitle() {

        return this.title;
    }

    //**************************************************************************

}