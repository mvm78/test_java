package test_java.reports;

import java.util.concurrent.ConcurrentHashMap;

public class SNMP extends Report {

    //**************************************************************************

    public SNMP() {

        this.setAppPath("/usr/local/mercury/bin/agg");
        this.setTitle("SNMP");
        this.setTilesFolder("SNMP");

        this.setTileList(new ConcurrentHashMap<String, String[]>() {{
            put("charts", new String[] {
                "SNMPVariablesChart",
            });
            put("tables", new String[] {
                "SNMPTopDeviceInterface",
                "SNMPVariables",
            });
        }});

        this.setTallyCheck(new ConcurrentHashMap<String, String[]>() {{
            put("SNMPTopDeviceInterface", new String[] {
                "SNMPVariables",
                "SNMPVariablesChart",
            });
        }});
    };

    //**************************************************************************

}