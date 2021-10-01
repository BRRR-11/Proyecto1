/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.clientes;

/**
 *
 * @author XPC
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pic extends JComponent implements MouseListener, FocusListener, MouseMotionListener {

    private Image img,img1;
    public Point p1;
    public Point p2;

    public Pic(Image img) {
        //this.img1=img1;
        this.img = img;
       // setFocusable(false);
        addMouseListener(this);
        addFocusListener(this);
        addMouseMotionListener(this);

    }


    @Override
    public void focusGained(FocusEvent e) {
        this.repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //requestFocusInWindow();

        System.out.println(MouseInfo.getPointerInfo().getLocation());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setFocusable(true);
        requestFocusInWindow();
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setFocusable(false);
        requestFocusInWindow();
        this.repaint();

    }

    public void paintComponent(Graphics g) {
        Graphics gr=g.create();
/*
      //  point =MouseInfo.getPointerInfo().getLocation();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, img.getWidth(this), img.getHeight(this) );

        g.drawImage(img,0,0, this);


//        if((p1!=null) && (int)p2.getX()>=380 && p2.getX()<=475 && (int)p2.getY()>=477 && (int)p2.getY()<=594 ) {
//            this.repaint();
//            g.setColor(Color.GREEN);
//            g.drawImage(img1,-179,-65,this);
//           // this.repaint();
//
//        }else {
//            g.setColor(Color.BLACK);
//        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, img.getWidth(this), img.getHeight(this));

        g.dispose();*/
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(p2.getX());
        requestFocusInWindow();
        p1=MouseInfo.getPointerInfo().getLocation();
        p2=MouseInfo.getPointerInfo().getLocation();

        e.getComponent().repaint();
    }
}
