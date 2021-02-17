package br.com.smartems.dmatnet.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CriptografiaString {

	public String obterHashString(String senha) {

		StringBuilder hexString = new StringBuilder();
		MessageDigest algoritmo;
		try {
			algoritmo = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algoritmo.digest(senha.getBytes());

			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return senha = hexString.toString();
		
	}
}
