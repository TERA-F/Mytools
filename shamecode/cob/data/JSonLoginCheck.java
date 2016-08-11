package cob.data;

public class JSonLoginCheck {
	private ErrInfo errInfo;
	private Data data;
	
	public class ErrInfo{
		private String no;

		public String getNo() {
			return no;
		}

		public void setNo(String no) {
			this.no = no;
		}
		
	}

	public class Data{
		private String codeString;
		private String mobile;
		private String userid;
		private String vcodetype;
		public String getCodeString() {
			return codeString;
		}
		public void setCodeString(String codeString) {
			this.codeString = codeString;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getVcodetype() {
			return vcodetype;
		}
		public void setVcodetype(String vcodetype) {
			this.vcodetype = vcodetype;
		}
		
	}

	
	public ErrInfo getErrInfo() {
		return errInfo;
	}

	public void setErrInfo(ErrInfo errInfo) {
		this.errInfo = errInfo;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
}
