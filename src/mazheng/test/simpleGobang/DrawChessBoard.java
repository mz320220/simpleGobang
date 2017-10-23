package mazheng.test.simpleGobang;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mz320 on 2017/5/3.
 */
public class DrawChessBoard extends JPanel{
    public Image boardImg;
    final  private int ROWS = 19;
    Chessman[][] chessStatus=new Chessman[ROWS][ROWS];
    public DrawChessBoard() {
        boardImg = Toolkit.getDefaultToolkit().getImage("simpleGobang/res/drawable/chessboard.png");
        if(boardImg == null){
            System.err.println("png do not exist");
        }

        //test draw chessman part simple
        Chessman chessman=new Chessman(0, true);
        chessStatus[7][7]=chessman;
        Chessman chessman2 = new Chessman(1, true);
        chessStatus[8][8]=chessman2;
        //test draw chessman part simple
    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        int imgWidth = boardImg.getWidth(this);
        int imgHeight = boardImg.getHeight(this);
        int FWidth = getWidth();
        int FHeight = getHeight();

        int x = (FWidth - imgWidth) / 2;
        int y = (FHeight - imgHeight) / 2;
        g.drawImage(boardImg, x, y, null);

        int margin = x;
        int span_x = imgWidth / ROWS;
        int span_y = imgHeight / ROWS;
        //画横线
        for (int i = 0; i < ROWS; i++) {
            g.drawLine(x, y + i * span_y, FWidth - x, y + i * span_y);
        }
        //画竖线
        for (int i = 0; i < ROWS; i++) {
            g.drawLine(x + i * span_x, y, x + i * span_x, FHeight - y);
        }
        //画旗子
        for(int i=0;i<ROWS;i++)
        {
            g.drawLine(x, y+i*span_y, FWidth-x,y+i*span_y);
        }
        //画竖线
        for(int i=0;i<ROWS;i++)
        {
            g.drawLine(x+i*span_x, y, x+i*span_x,FHeight-y);
        }

        //画棋子
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<ROWS;j++)
            {
                if(chessStatus[i][j]!=null&&chessStatus[i][j].getPlaced()==true)
                {
                    System.out.println("draw chessman "+i+" "+j);
                    int pos_x=x+i*span_x;
                    int pos_y=y+j*span_y;
                    int chessman_width=20;
                    float radius_b=20;
                    float radius_w=50;
                    float[] fractions = new float[]{0f,1f};
                    java.awt.Color[] colors_b = new java.awt.Color[]{Color.BLACK,Color.WHITE};
                    Color[] colors_w = new Color[]{Color.WHITE,Color.BLACK};
                    RadialGradientPaint paint;
                    if(chessStatus[i][j].getColor()==1)
                    {
                        System.out.println("draw white chess");
                        paint = new RadialGradientPaint(pos_x-chessman_width/2f, pos_y-chessman_width/2f, radius_w*2, fractions, colors_w);
                    }else{
                        System.out.println("draw black chess");
                        paint = new RadialGradientPaint(pos_x-chessman_width/2f, pos_y-chessman_width/2f, radius_b*2, fractions, colors_b);
                    }
                    ((Graphics2D)g).setPaint(paint);
                    ((Graphics2D)g).fillOval(pos_x-chessman_width/2,pos_y-chessman_width/2,chessman_width,chessman_width);
                }
            }
        }
    }

    public Image getBoardImg() {
        return boardImg;
    }
}
