package test_java.reports;

import java.util.*;

public class SNMP extends Report {

    //**************************************************************************

    public SNMP() {

        this.appPath = "/usr/local/mercury/bin/agg";
        this.refresh = "refreshTO 5.0";

        this.title = "SNMP";
        this.tilesFolder = "SNMP";

        this.tileList = new HashMap<String, ArrayList<String>>() {{
            put("charts", new ArrayList<String>() {{
                add("SNMPVariablesChart");
            }});
            put("tables", new ArrayList<String>() {{
                add("SNMPTopDeviceInterface");
                add("SNMPVariables");
            }});
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