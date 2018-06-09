/** 
 * Project Name:auth-common 
 * File Name:RsaKeyHelper.java 
 * Package Name:org.github.ycg000344.weiming.authcommon.jjwt.helper 
 * Date:2018年5月11日下午5:03:43 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.common.auth.jjwt.helper;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

/**
 * ClassName:RsaKeyHelper <br/>
 * <br/>
 * Description: RSA公钥、密钥相关操作 <br/>
 * <br/>
 * Date: 2018年5月11日 下午5:03:43 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
public class RsaKeyHelper {

	private RsaKeyHelper() {
	}

	private static RsaKeyHelper rsaKeyHelper;

	public static synchronized RsaKeyHelper getInstance() {
		if (null == rsaKeyHelper) {
			rsaKeyHelper = new RsaKeyHelper();
		}
		return rsaKeyHelper;
	}

	private static final String RSA = "RSA";
	public static final String PUB = "pub";
	public static final String PRI = "pri";

	/**
	 * 
	 * main:生成公钥、私钥文件. <br/>
	 * 
	 * @author po.lu
	 * @param args
	 * @since JDK 1.8
	 * @see
	 */
	public static void main(String[] args) {
		String publicKeyFilename = "C:\\Users\\Thinkive\\Desktop\\pub.key";
		String privateKeyFilename = "C:\\Users\\Thinkive\\Desktop\\pri.key";
		RsaKeyHelper helper = new RsaKeyHelper();
		try {
			helper.generateKey(publicKeyFilename, privateKeyFilename, "wm.weiming.org");
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * toHexString:字节数组转为字符. <br/> 
	 * 
	 * @author po.lu
	 * @param b
	 * @return 
	 * @since JDK 1.8 
	 * @see
	 */
	public String toHexString(byte[] b) {
        return Base64.encode(b);
    }

	/**
	 * 
	 * toBytes:字符转字节数组. <br/> 
	 * 
	 * @author po.lu
	 * @param s
	 * @return
	 * @throws IOException 
	 * @since JDK 1.8 
	 * @see
	 */
	public final byte[] toBytes(String s) throws IOException {
        return Base64.decode(s);
    }

	/**
	 * 
	 * getPrivateKey:获取密钥. <br/>
	 * 
	 * @author po.lu
	 * @param filename
	 *            私钥文件路径
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @since JDK 1.8
	 * @see
	 */
	public PrivateKey getPrivateKey(String filename) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return getPrivateKey(new FileReader(filename).readBytes());
	}

	/**
	 * 
	 * getPrivateKey:获取密钥. <br/>
	 * 
	 * @author po.lu
	 * @param privateKey
	 *            byte[]
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @since JDK 1.8
	 * @see
	 */
	public PrivateKey getPrivateKey(byte[] privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory kf = KeyFactory.getInstance(RSA);
		return kf.generatePrivate(spec);
	}

	/**
	 * 
	 * getPublicKey:获取公钥. <br/>
	 * 
	 * @author po.lu
	 * @param filename
	 *            公钥文件路径
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @since JDK 1.8
	 * @see
	 */
	public PublicKey getPublicKey(String filename) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return getPublicKey(new FileReader(filename).readBytes());
	}

	/**
	 * 
	 * getPublicKey:获取公钥. <br/>
	 * 
	 * @author po.lu
	 * @param publicKey
	 *            byte[]
	 * @return
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws Exception
	 * @since JDK 1.8
	 * @see
	 */
	public PublicKey getPublicKey(byte[] publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
		X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey);
		KeyFactory kf = KeyFactory.getInstance(RSA);
		return kf.generatePublic(spec);
	}

	/**
	 * 
	 * generateKey:生存rsa公钥和密钥 <br/>
	 * 
	 * @author po.lu
	 * @param publicKeyFilename
	 *            公钥
	 * @param privateKeyFilename
	 *            私钥
	 * @param password
	 *            密码
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @since JDK 1.8
	 * @see
	 */
	public void generateKey(String publicKeyFilename, String privateKeyFilename, String password)
			throws IOException, NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
		password = Base64.encode(password);
		SecureRandom secureRandom = new SecureRandom(password.getBytes());
		keyPairGenerator.initialize(1024, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
		new FileWriter(publicKeyFilename).write(publicKeyBytes, 0, publicKeyBytes.length);
		byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
		new FileWriter(privateKeyFilename).write(privateKeyBytes, 0, privateKeyBytes.length);
	}

	/**
	 * 
	 * generateKey:生成公钥、私钥存储于内存当中. <br/>
	 * 
	 * @author po.lu
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @since JDK 1.8
	 * @see
	 */
	public Map<String, byte[]> generateKey(String password) throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
		password = Base64.encode(password);
		SecureRandom secureRandom = new SecureRandom(password.getBytes());
		keyPairGenerator.initialize(1024, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
		byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
		Map<String, byte[]> map = new HashMap<String, byte[]>();
		map.put(PUB, publicKeyBytes);
		map.put(PRI, privateKeyBytes);
		return map;
	}

}
