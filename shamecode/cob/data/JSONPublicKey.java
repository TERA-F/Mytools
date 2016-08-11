package cob.data;

public class JSONPublicKey {
	private String errno;
	private String key;
	private String msg;
	private String pubkey;
	public String getErrno() {
		return errno;
	}
	public void setErrno(String errno) {
		this.errno = errno;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPubkey() {
		return pubkey;
	}
	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}
	
}
