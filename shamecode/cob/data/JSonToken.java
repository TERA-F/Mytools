package cob.data;

public class JSonToken {
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
		private String cookie;
		private String disable;
		private LoginRecord loginrecord;
		private String rememberedUserName;
		private String spLogin;
		private String token;
		private String usernametype;
		
		public class LoginRecord{
			private char[] email; 
			private int[] phone;
			
			public char[] getEmail() {
				return email;
			}
			public void setEmail(char[] email) {
				this.email = email;
			}
			public int[] getPhone() {
				return phone;
			}
			public void setPhone(int[] phone) {
				this.phone = phone;
			}
		}

		public String getCodeString() {
			return codeString;
		}

		public void setCodeString(String codeString) {
			this.codeString = codeString;
		}

		public String getCookie() {
			return cookie;
		}

		public void setCookie(String cookie) {
			this.cookie = cookie;
		}

		public String getDisable() {
			return disable;
		}

		public void setDisable(String disable) {
			this.disable = disable;
		}

		public LoginRecord getLoginrecord() {
			return loginrecord;
		}

		public void setLoginrecord(LoginRecord loginrecord) {
			this.loginrecord = loginrecord;
		}

		public String getRememberedUserName() {
			return rememberedUserName;
		}

		public void setRememberedUserName(String rememberedUserName) {
			this.rememberedUserName = rememberedUserName;
		}

		public String getSpLogin() {
			return spLogin;
		}

		public void setSpLogin(String spLogin) {
			this.spLogin = spLogin;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getUsernametype() {
			return usernametype;
		}

		public void setUsernametype(String usernametype) {
			this.usernametype = usernametype;
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
