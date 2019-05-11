/**
 * 
 */
package br.com.exercise;

/**
 * @author SAULO
 *
 */
public class CalcSubStringLength {

	/**
	 * 
	 */
	public CalcSubStringLength() {
		super();
	}
	
	public int calc(String input) {
		
		// caracteres em processamento
		StringBuilder inProcess = new StringBuilder();
		
		// maior substring encontrada
		String longestString = new String();
		
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			
			// se o caracter for encontrado,
			// removo todos anterioes a ele, inclusive ele
			int indexOf = inProcess.indexOf(String.valueOf(charAt));
			if (indexOf >= 0) {
				inProcess.delete(0, ++indexOf);
			}
			
			// concatena os valores processados
			inProcess.append(charAt);
			
			// verifica se o em processamento é maior que o armazenado
			// se for positivo salvo a nova maior substring
			if (inProcess.length() > longestString.length()) {
				longestString = inProcess.toString();
			}
		}
		
		return longestString.length();
	}

}
