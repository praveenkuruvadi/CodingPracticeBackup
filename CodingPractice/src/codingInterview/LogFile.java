package codingInterview;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class LogFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String log = "2016-02-12T03:21:56z	test";
		System.out.println(log.split("\t")[0].split("T")[1].trim());
		String lognew = log.split("\t")[0].split("T")[1].trim();
		LocalTime timeTemp = LocalTime.parse(lognew.substring(0, lognew.length()-1));
		System.out.println(timeTemp);

	}
	
    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
        ArrayList<String> outList = new ArrayList<String>();
        LocalTime timeTemp = LocalTime.parse("00:00:00");
        for(String log:logLines){
            timeTemp = LocalTime.parse(log.split("Z")[0].split("T")[1].trim());
            if(timeTemp.compareTo(startDate)>=0 && timeTemp.compareTo(endDate)<0)
                outList.add(log);
        }

        return outList;
    }

}
