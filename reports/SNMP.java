package test_java.reports;

import java.util.*;

public class SNMP extends Report {

    //**************************************************************************

    public SNMP() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.refresh = "refreshTO 5.0";

        this.setTitle("SNMP");
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

}