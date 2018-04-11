
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontTest {
    public static void main(String [] args){
        EventQueue.invokeLater(()->
                {
                    JFrame jFrame=new ButtonFrame();
                    jFrame.setTitle("PlafFrame");
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.setVisible(true);
                }
        );
    }
}

class FontFrame extends JFrame{
    public FontFrame(){
        add(new FontComponent());
        pack();
    }
}

class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFALUT_HEIGHT=200;

    public void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        String message="Hello!";
        Font f=new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        FontRenderContext context=g2.getFontRenderContext();
        Rectangle2D bounds=f.getStringBounds(message, context);

        double x=(getWidth()-bounds.getWidth())/2;
        double y=(getHeight()-bounds.getHeight())/2;

        double ascent=-bounds.getY();
        double baseY=y+ascent;

        g2.drawString(message, (int) x, (int)baseY);
        g2.setPaint(Color.LIGHT_GRAY);

        g2.draw(new Line2D.Double(x, baseY, x+bounds.getWidth(), baseY));

        Rectangle2D rect=new Rectangle2D.Double(x,y,bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFALUT_HEIGHT);
    }



}

class ImageFrame extends JFrame{
    public ImageFrame(){
        add(new ImageComponent());
        pack();
    }
}

    class ImageComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFALUT_HEIGHT = 200;

        private Image image;

        public ImageComponent(){
            image=new ImageIcon("jkj.png").getImage();
        }
        public void paintComponent(Graphics g) {
            if (image==null)return;
            int imageWidth=image.getWidth(this);
            int imageHeight=image.getHeight(this);

            g.drawImage(image, 0, 0, null);

            for(int i=0;i*imageWidth<=getWidth();i++){
                for (int j=0;j*imageHeight<=getHeight(); j++){
                    if(i+j>0)
                        g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
                }
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFALUT_HEIGHT);
        }
    }

    class ButtonFrame extends JFrame{
        private JPanel buttonPanel1;
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFALUT_HEIGHT = 200;
        public ButtonFrame(){
            setSize(DEFAULT_WIDTH, DEFALUT_HEIGHT);


            buttonPanel1=new JPanel();


            add(buttonPanel1);

            ColorAction yellowAction=new ColorAction("yellow", new ImageIcon("dkfjslf"),Color.YELLOW);
            ColorAction blueAction=new ColorAction("blue", new ImageIcon("dkfjslf"),Color.BLUE);
            ColorAction redAction=new ColorAction("red", new ImageIcon("dkfjslf"),Color.RED);

            JButton yellowButton=new JButton(yellowAction);
            JButton blueButton =new JButton(blueAction);
            JButton redButton=new JButton(redAction);
            buttonPanel1.add(yellowButton);
            buttonPanel1.add(blueButton);
            buttonPanel1.add(redButton);
//            yellowButton.addActionListener(yellowAction);
//            blueButton.addActionListener(blueAction);
//            redButton.addActionListener(redAction);


        }

        private class ColorAction extends AbstractAction{
            public ColorAction(String name,Icon icon, Color c) {
                putValue(Action.NAME, name);
                putValue(Action.SMALL_ICON, icon);
                putValue("color", c);
                putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            }
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color c=(Color) getValue("color");
                buttonPanel1.setBackground(c);
            }
        }
}

class PlafFrame extends JFrame
{
    private JPanel buttonPanel1;

    public PlafFrame() {
        buttonPanel1=new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(), info.getClassName());

        add(buttonPanel1);
        pack();
    }

    private void makeButton(String name, String className){
        JButton button=new JButton(name);
        buttonPanel1.add(button);

        button.addActionListener(event->{
            try{
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }
}