package hello;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pawn {
	int x,y;
	int current;
	int height,width;
	public Pawn(int h,int w){
		current=-1;
		x=-1;
		y=-1;
		height=h;
		width=w;
	}
	public void draw(GraphicsContext g, int i, int j, int play) {
		int temp1=80+(height/2);
		int temp2=50+(width/2);
		if(current==-1) {

			x=i;
			y=j;
//			if(play==0) {a
//				g.setColor();
//			}
//			else if(play==1) {
//				g.setColor(Color.GREEN);
//			}
//			else if(play==2) {
//				g.setColor(Color.YELLOW);
//			}
//			else if(play==3) {
//				g.setColor(Color.BLUE);
//			}
			g.fillOval(100,100,100,100);
			g.setStroke(Color.BLUEVIOLET);
//			g.setColor(Color.BLACK);:O
//	    	g.drawOval(temp1+5+(i*width),temp2+5+(j*height),width-10,height-10);
		}
		else
		{
			temp1=80;
			temp2=50;
			x=i;
			y=j;
//			if(play==0) {
//				g.setColor(Color.RED);
//			}
//			else if(play==1) {
//				g.setColor(Color.GREEN);
//			}
//			else if(play==2) {
//				g.setColor(Color.YELLOW);
//			}
//			else if(play==3) {
//				g.setColor(Color.BLUE);
			}
			g.fillOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10);
		g.fillOval(100,100,100,100);

			g.setStroke(Color.ANTIQUEWHITE);
//			g.set;
//	    	g.drawOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10);
		}
	}
