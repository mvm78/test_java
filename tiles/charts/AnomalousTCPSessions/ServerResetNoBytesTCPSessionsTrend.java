package test_java.tiles.charts.AnomalousTCPSessions;

public class ServerResetNoBytesTCPSessionsTrend extends AnomalousTCPSessionsTrend {

    //**************************************************************************

    public ServerResetNoBytesTCPSessionsTrend() {

        this.title = "Server Reset (No Bytes) TCP Sessions Trend";
        this.suffix = "pq 'client.byte==0 and server.flags==rst' w 0 '|' TcpAgg count conn";
    }

    //**************************************************************************

}