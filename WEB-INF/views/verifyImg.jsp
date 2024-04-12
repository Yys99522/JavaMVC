<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.awt.*,java.awt.image.*"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.imageio.*" %>
<%@ page session="true" %>


<%
  	response.setHeader("Cache-Control","no-cache");
  	response.setDateHeader("Expires", 0);


  	int width=90, height=40; 
  	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);



  	Graphics g = image.getGraphics();   
  	Random random = new Random();

	g.setColor(Color.WHITE);
	g.fillRect(0, 0, width, height);
  	g.setFont(new Font("Times New Roman",Font.PLAIN,24));

  	String sRand=""; 
  
  	for(int i=0; i<4; i++){
      	String rand=String.valueOf(random.nextInt(10));
     	sRand+=rand;
     	g.setColor(new Color(random.nextInt(128),random.nextInt(128),random.nextInt(128)));
      	g.drawString(rand,20*i+6,28);
  	}

  	g.setColor(new Color(127+random.nextInt(128),127+random.nextInt(128),127+random.nextInt(128)));
  	int x1,y1,x2,y2;
  	for(int i=0;i<4;i++){
		x1=random.nextInt(90);
		y1=random.nextInt(40);
		x2=random.nextInt(90);
		y2=random.nextInt(40);
		g.drawLine(x1, y1, x2, y2);
  	}

   	session.setAttribute("verifynum", sRand);

  	g.dispose();

  	out.clear();
  	out=pageContext.pushBody();
  

  	ImageIO.write(image, "JPEG", response.getOutputStream());
  
%>