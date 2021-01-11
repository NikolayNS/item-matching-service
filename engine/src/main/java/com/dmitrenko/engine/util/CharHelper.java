package com.dmitrenko.engine.util;

public class CharHelper {

	private CharHelper() {
	}

	public static boolean isSymbol(char c) {
		return c == ' ' || c == ',' || c == '.'
			|| c == '_' || c == ':' || c == ';'
			|| c == '\'' || c == '\"' || c == '('
			|| c == ')' || c == '[' || c == ']'
			|| c == '{' || c == '}' || c == '/'
			|| c == '\\' || c == '?' || c == '!'
			|| c == '^' || c == '$' || c == '#'
			|| c == '*' || c == '+' || c == '-'
			|| c == '~' || c == '<' || c == '='
			|| c == '>';
	}
}
