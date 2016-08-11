package cob.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrNoData {
	private String err_no;
	private String codeString;
	private String vcodetype;
	private String bcsync;
	private String bcchecksum;

	@SuppressWarnings("unused")
	private ErrNoData() {	}
	
	public ErrNoData(String responsebody) {
		Pattern r1 = Pattern.compile("(err_no[^\"]+)");
		Matcher m1 = r1.matcher(responsebody);
		m1.find();
		Pattern r2 = Pattern.compile("([^&]+)");
		Matcher m2 = r2.matcher(m1.group(0));
		while(m2.find()){
			Pattern tmpp = Pattern.compile("[^=]+");
			Matcher tmpm = tmpp.matcher(m2.group(1));
			tmpm.find();
			if(tmpm.group(0).equals("err_no")){
				tmpm.find();
				setErr_no(tmpm.group(0));
				continue;
			}
			if(tmpm.group(0).equals("codeString")){
				if(tmpm.find())
					setCodeString(tmpm.group(0)==null ? "":tmpm.group(0));
				continue;
			}
			if(tmpm.group(0).equals("vcodetype")){
				if(tmpm.find())
					setVcodetype(tmpm.group(0));
				continue;
			}if(tmpm.group(0).equals("bcsync")){
				if(tmpm.find())
					setBcsync(tmpm.group(0));
				continue;
			}if(tmpm.group(0).equals("bcchecksum")){
				if(tmpm.find())
					setBcchecksum(tmpm.group(0));
				continue;
			}
		}		
	}

	public String getErr_no() {
		return err_no;
	}

	public void setErr_no(String err_no) {
		this.err_no = err_no;
	}

	public String getCodeString() {
		return codeString;
	}

	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}

	public String getVcodetype() {
		return vcodetype;
	}

	public void setVcodetype(String vcodetype) {
		this.vcodetype = vcodetype;
	}

	public String getBcsync() {
		return bcsync;
	}

	public void setBcsync(String bcsync) {
		this.bcsync = bcsync;
	}

	public String getBcchecksum() {
		return bcchecksum;
	}

	public void setBcchecksum(String bcchecksum) {
		this.bcchecksum = bcchecksum;
	}

	
}
