/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.console.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Classe utilitaria com facilidades para envio de e-mail.<br/>
 * Pode ser utilizada com servidores que exigem autenticacao.<br/>
 * Habilita o envio de e-mails formatados em html e contendo anexos.</br>
 * @author marcio.guedes
 *
 */
public class Mailer {
	
	
	/**
	 * Constroi um Mailler conectando em smtpHost:smtpPort<br/>
	 * Usa autenticacao passando smtpUser como usuario e smtpPassword como senha. 
	 * @param smtpHost
	 * @param smtpPort
	 * @param smtpUser
	 * @param smtpPassword
	 */
	public Mailer(String smtpHost,int smtpPort,String smtpUser,String smtpPassword, boolean useSSL){
		SimpleAuth simple=new SimpleAuth(smtpUser,smtpPassword);
		init(smtpHost,smtpPort,simple,useSSL);
	}
	
	/**
	 * Constroi um Mailler conectando em smtpHost:smtpPort sem autenticacao.
	 * @param smtpHost
	 * @param smtpPort
	 */
	public Mailer(String smtpHost,int smtpPort){
		init(smtpHost,smtpPort,null,false);		
	}
	
	/**
	 * Constroi um Mailler conectando em smtpHost na porta 25 sem autenticacao.
	 * @param smtpHost
	 */
	public Mailer(String smtpHost){
		init(smtpHost,25,null,false);
	}
	
	
	private static final Log logger=LogFactory.getLog(Mailer.class);
	private MimeMessage msg;
	private StringBuffer body=new StringBuffer();
	private String subject="";
	private Session session;
	private String from;
	private ArrayList<String> to=new ArrayList<String>();
	private ArrayList<String> cc=new ArrayList<String>();
	private ArrayList<String> bcc=new ArrayList<String>();
	private ArrayList<File> files=new ArrayList<File>();
	
	public String getBody() {
		return body.toString();
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	private void init(String smtpHost,int smtpPort,Authenticator auth,boolean useSSL){
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port",Integer.toString(smtpPort));
		props.put("mail.smtp.auth",auth!=null? "true":"false");
		if(useSSL){
			 props.put ("mail.smtp.starttls.enable", "true");
			 props.put ("mail.smtp.socketFactory.port", Integer.toString(smtpPort));
			 props.put ("mail.smtp.socketFactory.fallback", "false");
			 props.put ("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		}
		
		session = Session.getDefaultInstance(props, auth);		
	}

	
	
	public void setTo(ArrayList<String> to){
		this.to=to;
	}
	
	public void setCc(ArrayList<String> cc){
		this.cc=cc;
	}
	
	public void setBcc(ArrayList<String> bcc){
		this.bcc=bcc;
	}
	
	
	public void addTo(String member){
		to.add(member);
	}
	
	public void addTo(Vector<String> to){
		this.to.addAll(to);
	}
	
	public void addCc(String member){
		cc.add(member);
	}
	
	public void addCc(Vector<String> cc){
		this.cc.addAll(cc);
	}
	
	public void addBcc(String member){
		bcc.add(member);	
	}
	
	public void addBcc(Vector<String> bcc){
		this.bcc.addAll(bcc);
	}
	
	public void addFile(File file){
		this.files.add(file);
	}
		
	
	private void fillParts() throws UnsupportedEncodingException, MessagingException {
		//Reset message
		msg = new MimeMessage(session);
		
		msg.setSubject(MimeUtility.encodeText(subject,"iso-8859-1",null));	
		msg.setFrom(new InternetAddress(from));
		
		Iterator<String> itTo=to.iterator();
		while (itTo.hasNext())
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(itTo.next()));
		
		Iterator<String> itCc=cc.iterator();
		while(itCc.hasNext())
			msg.addRecipient(Message.RecipientType.CC,new InternetAddress(itCc.next()));
		
		Iterator<String> itBCc=bcc.iterator();
		while(itBCc.hasNext())
			msg.addRecipient(Message.RecipientType.BCC,new InternetAddress( itBCc.next()));
		
		
		Multipart mp = new MimeMultipart();		
		// Create and fill the first message part
		{
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent(getBody(),"text/html");
			
			// Attach the part to the multipart;
			mp.addBodyPart(mbp);
		}
		
		Iterator<File> itFiles=files.iterator();
		while(itFiles.hasNext()){
			MimeBodyPart mbp = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(itFiles.next());
			mbp.setDataHandler(new DataHandler(fds));
			mbp.setFileName(fds.getName());
			mbp.setHeader("Content-ID","<"+fds.getName()+">");
			mp.addBodyPart(mbp);
		}
		
		msg.setContent(mp);
	}
	
	public StringBuffer appendBody(String part){
		return body.append(part);		
	}
	
	
	public void send() throws MessagingException, UnsupportedEncodingException{
		logger.debug("Tentando enviar mensagem para "+to.toString()+" usando "+session.getProperty("mail.smtp.host"));
		fillParts();
		msg.setSentDate(new Date());
		Transport.send(msg) ;		
		logger.debug("Mensagem enviada com sucesso.");
	}
	
	public String toString(){
		StringBuffer bf=new StringBuffer();
		bf.append("FROM:"+from+"\n");
		bf.append("TO:"+to+"\n");
		bf.append("CC:"+cc+"\n");
		bf.append("BCC:"+bcc+"\n");
		bf.append("BODY:\n"+body+"\n");
		bf.append("FILES:"+files);		
		return bf.toString();
	}
	
	class SimpleAuth extends Authenticator {
        public String username = null;
        public String password = null;

        public SimpleAuth(String user, String pwd) {
            username = user;
            password = pwd;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username,password);
        }
    }
	
	
	public static void main(String[] args) throws Exception, MessagingException {
		Mailer mailer = new Mailer("mail.navita.com.br",25);
		mailer.appendBody("teste 1234");
		mailer.setFrom("sender@navita.com.br");
		mailer.addTo("mpguedes@gmail.com");
		mailer.setSubject("Teste 123");
		mailer.send();
	}
}

