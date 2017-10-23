package mazheng.test.simpleGobang;

import javax.swing.*;
import java.awt.*;
/**
 * Created by mz320 on 2017/5/3.
 */
public class Main extends JFrame{
    private DrawChessBoard drawChessBoard;
    public Main() {
        drawChessBoard = new DrawChessBoard();

        //Frame标题
        setTitle("单机五子棋");
        Container containerPane =getContentPane();
        containerPane.add(drawChessBoard);

        /*Image chessBoardImage = drawChessBoard.getBoardImg();
        int imgWidth = chessBoardImage.getWidth(this);
        int imgHeight = chessBoardImage.getHeight(this);*/
    }
    public static void main(String[] args) {
        Main m = new Main();
        //m.setSize(1200,1200);
        m.setBounds(800,400,600*2,600*2);
        m.setVisible(true);
    }
}
