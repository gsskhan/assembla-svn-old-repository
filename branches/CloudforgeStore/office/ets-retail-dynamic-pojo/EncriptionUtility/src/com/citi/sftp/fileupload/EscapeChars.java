package com.citi.sftp.fileupload;

public enum EscapeChars {
	NEW_LINE('\n'), 
	CARRIAGE_RETURN('\r'),
	TAB('\t'),
	PIPE('|'), 
	SEMICOLON(';'),
	COMMA(',');
	
	private final char ESCAPE_CHAR;
	
	EscapeChars(char escapeChar) {
		this.ESCAPE_CHAR = escapeChar;
	}
	
	public char getEscapeChar(){
		return ESCAPE_CHAR;
	}
}
