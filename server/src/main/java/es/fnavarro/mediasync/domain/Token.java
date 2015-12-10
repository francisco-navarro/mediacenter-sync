package es.fnavarro.mediasync.domain;

public class Token {
	
	private String token;
	private static final long MINUS_VALUE = System.currentTimeMillis();
	private static final long MAX_TIME = 1000*60*5;
	
	public Token(){}
	
	public static Token createToken(){
		Token token = new Token();
		token.setToken(Long.toString(System.currentTimeMillis() - MINUS_VALUE));
		return token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean isValid(){
		long result = MINUS_VALUE + Long.valueOf(token);
		return result < System.currentTimeMillis() + MAX_TIME;
	}

}
