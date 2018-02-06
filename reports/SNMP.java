package test_java.reports;

import java.util.*;

public class SNMP extends Report {

    //**************************************************************************

    public SNMP() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("SNMP");
        this.setTilesFolder("SNMP");

        this.setTileList(new HashMap<String, String []>() {{
            put("charts", new String [] {
                "SNMPVariablesChart",
            });
            put("tables", new String [] {
                "SNMPTopDeviceInterface",
                "SNMPVariables",
            });
        }});

        this.setTallyCheck(new HashMap<String, String []>() {{
            put("SNMPTopDeviceInterface", new String [] {
                "SNMPVariables",
                "SNMPVariablesChart",
            });
        }});
    };

    //**************************************************************************

}